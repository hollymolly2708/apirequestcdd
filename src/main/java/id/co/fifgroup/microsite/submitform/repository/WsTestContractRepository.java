package id.co.fifgroup.microsite.submitform.repository;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestContract;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WsTestContractRepository extends JpaRepository<WsTestContract, Long> {
    Boolean existsByContractNumber(String contractNumber);
    WsTestContract findByContractNumber(String contractNumber);
}
