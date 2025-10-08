package id.co.fifgroup.microsite.submitform.service;

import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;

public interface OtpService {
    public ApiResponse<String> requestOtp(Long contractId);
    public ApiResponse<String> validateOtp(Long contractId, String otpCode);
}
