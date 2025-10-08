package id.co.fifgroup.microsite.submitform.repository;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WsTestOtpRepository extends JpaRepository<WsTestOtp, Long> {
    public WsTestOtp findByContractId(Long contractId);
}
