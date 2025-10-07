package id.co.fifgroup.microsite.submitform.model.request;

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
public class WsTestContractRequest {
    private String contractNumber;
    private String name;
    private String nik;
    private String alamat;
    private Date tanggalKontrak;
    private Date tanggalLahir;
}
