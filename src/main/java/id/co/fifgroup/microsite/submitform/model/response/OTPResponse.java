package id.co.fifgroup.microsite.submitform.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OTPResponse {
    private String message;
    private String otpCode;
}
