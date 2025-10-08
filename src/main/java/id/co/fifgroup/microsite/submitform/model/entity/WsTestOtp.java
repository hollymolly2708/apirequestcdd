package id.co.fifgroup.microsite.submitform.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "WS_TEST_OTP", schema = "FIFWS")
public class WsTestOtp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "otp_id")
    private Long otpId;
    @Column(name="contract_id")
    private Long contractId;
    @Column(name = "otp_code")
    private String otpCode;
    @Column(name = "is_verified")
    private Boolean isVerified;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "expired_at")
    private Timestamp expiredAt;

}
