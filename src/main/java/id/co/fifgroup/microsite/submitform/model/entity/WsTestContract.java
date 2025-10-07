package id.co.fifgroup.microsite.submitform.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "WS_TEST_CONTRACT", schema = "FIFWS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WsTestContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contractId;
    @Column(name = "contract_number")
    private String contractNumber;
    @Column(name = "nama")
    private String nama;
    @Column(name = "nik")
    private String nik;
    @Lob
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "tanggal_kontrak")
    private Date tanggalKontrak;
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;
    @Column(name = "created_at")
    private Timestamp createdAt;

    // Relasi ke Submission (one-to-one)
    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL)
    private WsTestSubmissions submission;

}
