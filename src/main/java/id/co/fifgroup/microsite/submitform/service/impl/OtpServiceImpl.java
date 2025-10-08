package id.co.fifgroup.microsite.submitform.service.impl;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestOtp;
import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.repository.WsTestOtpRepository;
import id.co.fifgroup.microsite.submitform.service.OtpService;
import id.co.fifgroup.microsite.submitform.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OtpServiceImpl implements OtpService {
    @Autowired
    private WsTestOtpRepository otpRepository;

    @Override
    public ApiResponse<String> requestOtp(Long contractId) {
        WsTestOtp wsTestOtp = otpRepository.findByContractId(contractId);

        String otp = Utilities.generateOtp();
        wsTestOtp.setOtpCode(otp);
        wsTestOtp.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        wsTestOtp.setIsVerified(false);
        otpRepository.save(wsTestOtp);
        return ApiResponse.<String>builder().data("Request OTP berhasil, kode OTP: " + otp).code(200L).build();
    }

    @Override
    public ApiResponse<String> validateOtp(Long contractId, String otpCode) {
        WsTestOtp wsTestOtp = otpRepository.findByContractId(contractId);
        if (!wsTestOtp.getIsVerified() && wsTestOtp.getOtpCode().equals(otpCode)) {
            wsTestOtp.setIsVerified(true);
            otpRepository.save(wsTestOtp);
            return ApiResponse.<String>builder().data("OTP valid").code(200L).build();
        }
        if(wsTestOtp.getIsVerified()){
            return ApiResponse.<String>builder().data("OTP sudah divalidasi").code(200L).build();
        }
        return ApiResponse.<String>builder().data("OTP tidak valid").code(400L).build();
    }
}
