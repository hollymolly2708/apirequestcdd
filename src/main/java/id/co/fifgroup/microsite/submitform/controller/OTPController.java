package id.co.fifgroup.microsite.submitform.controller;

import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class OTPController {
    @Autowired
    private OtpService otpService;

    @PostMapping("/request-otp")
    public ApiResponse<String> requestOtp(Long contractId) {
        return otpService.requestOtp(contractId);
    }

    @PostMapping("/validate-otp")
    public ApiResponse<String> validateOtp(@RequestParam Long contractId, @RequestParam String otpCode) {
        return otpService.validateOtp(contractId, otpCode);
    }
}
