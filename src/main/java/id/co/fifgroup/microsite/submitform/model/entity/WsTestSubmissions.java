package id.co.fifgroup.microsite.submitform.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WS_TEST_SUBMISSIONS", schema = "FIFWS")
public class WsTestSubmissions {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Long submissionId;
    @Column(name = "submitted_at")
    private Timestamp submittedAt;

    // Relasi ke Contract
    @OneToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id")
    private WsTestContract contract;

}
