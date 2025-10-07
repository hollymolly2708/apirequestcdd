package id.co.fifgroup.microsite.submitform.service.impl;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestContract;
import id.co.fifgroup.microsite.submitform.model.entity.WsTestSubmissions;
import id.co.fifgroup.microsite.submitform.model.request.WsTestContractRequest;
import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.repository.WsTestContractRepository;
import id.co.fifgroup.microsite.submitform.repository.WsTestSubmissionRepository;
import id.co.fifgroup.microsite.submitform.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SubmitServiceImpl implements SubmitService {

    @Autowired
    WsTestSubmissionRepository wsTestSubmissionRepository;

    @Autowired
    WsTestContractRepository wsTestContractRepository;


    @Override
    public ApiResponse<String> submit(WsTestContractRequest request) {
        if (wsTestContractRepository.existsByContractNumber(request.getContractNumber())) {
            return ApiResponse.<String>builder()
                    .data("Contract number already exists")
                    .code(400L)
                    .build();
        }

        WsTestContract contract = new WsTestContract();
        contract.setContractNumber(request.getContractNumber());
        contract.setNik(request.getNik());
        contract.setAlamat(request.getAlamat());
        contract.setNama(request.getName());
        contract.setTanggalKontrak(request.getTanggalKontrak());
        contract.setTanggalLahir(request.getTanggalLahir());
        contract.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        wsTestContractRepository.save(contract);

        WsTestSubmissions submission = new WsTestSubmissions();
        submission.setContract(contract);
        submission.setSubmittedAt(new Timestamp(System.currentTimeMillis()));
        wsTestSubmissionRepository.save(submission);


        return ApiResponse.<String>builder()
                .data("Data berhasil terkirim ke FIFWS")
                .code(200L)
                .build();
    }

}
