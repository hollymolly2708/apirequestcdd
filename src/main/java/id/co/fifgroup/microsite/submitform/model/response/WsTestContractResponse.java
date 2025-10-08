package id.co.fifgroup.microsite.submitform.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WsTestContractResponse {

    private Long contractId;
    private String contractNumber;
    private String nama;
    private String nik;
    private String alamat;
    private Date tanggalKontrak;
    private Date tanggalLahir;
    private Timestamp createdAt;
}
