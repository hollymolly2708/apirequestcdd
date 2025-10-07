package id.co.fifgroup.microsite.submitform.repository;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestSubmissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WsTestSubmissionRepository extends JpaRepository<WsTestSubmissions, Long> {
}
