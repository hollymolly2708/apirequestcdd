package id.co.fifgroup.microsite.submitform.service.impl;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestOtp;
import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.model.response.OTPResponse;
import id.co.fifgroup.microsite.submitform.repository.WsTestOtpRepository;
import id.co.fifgroup.microsite.submitform.service.OtpService;
import id.co.fifgroup.microsite.submitform.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class OtpServiceImpl implements OtpService {
    @Autowired
    private WsTestOtpRepository otpRepository;

    @Override
    public ApiResponse<OTPResponse> requestOtp(Long contractId) {
        WsTestOtp wsTestOtp = otpRepository.findByContractId(contractId);

        // Generate OTP baru setiap kali request
        String otp = Utilities.generateOtp();
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp expiredAt = new Timestamp(createdAt.getTime() + (30 * 60 * 1000)); // 30 menit dari createdAt

        if (wsTestOtp == null) {
            // Jika belum ada data OTP untuk contract ini, buat baru
            wsTestOtp = new WsTestOtp();
            wsTestOtp.setContractId(contractId);
            wsTestOtp.setOtpId(UUID.randomUUID().toString());
        }

        // Update / Set field OTP setiap kali request
        wsTestOtp.setOtpCode(otp);
        wsTestOtp.setCreatedAt(createdAt);
        wsTestOtp.setExpiredAt(expiredAt);
        wsTestOtp.setIsVerified(false);

        otpRepository.save(wsTestOtp);

        return ApiResponse.<OTPResponse>builder()
                .data(OTPResponse.builder().message("Request OTP berhasil").otpCode(otp).build())
                .code(200L)
                .build();
    }


    @Override
    public ApiResponse<String> validateOtp(Long contractId, String otpCode) {
        WsTestOtp wsTestOtp = otpRepository.findByContractId(contractId);

        if (wsTestOtp == null) {
            return ApiResponse.<String>builder().data("OTP tidak ditemukan untuk contract ID ini").code(401L).build();
        }
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (wsTestOtp.getExpiredAt().before(now)) {
            return ApiResponse.<String>builder().data("OTP sudah kadaluwarsa").code(403L).build();
        }

        if (wsTestOtp.getIsVerified()) {
            return ApiResponse.<String>builder().data("OTP sudah divalidasi").code(404L).build();
        }

        if (!wsTestOtp.getOtpCode().equals(otpCode)) {
            return ApiResponse.<String>builder().data("OTP tidak valid").code(405L).build();
        }

        wsTestOtp.setIsVerified(true);
        otpRepository.save(wsTestOtp);

        return ApiResponse.<String>builder().data("OTP Valid").code(200L).build();
    }
}
