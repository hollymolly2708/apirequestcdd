package id.co.fifgroup.microsite.submitform.service;

import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.model.response.OTPResponse;

public interface OtpService {
    public ApiResponse<OTPResponse> requestOtp(Long contractId);
    public ApiResponse<String> validateOtp(Long contractId, String otpCode);
}
