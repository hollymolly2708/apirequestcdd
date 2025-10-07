package id.co.fifgroup.microsite.submitform.service.impl;

import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.repository.WsTestContractRepository;
import id.co.fifgroup.microsite.submitform.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {


    public final WsTestContractRepository wsTestContractRepository;

    @Autowired
    public ContractServiceImpl(WsTestContractRepository wsTestContractRepository) {
        this.wsTestContractRepository = wsTestContractRepository;
    }

    @Override
    public ApiResponse<Boolean> contractValidation(String contractNumber) {
        Boolean exists = wsTestContractRepository.existsByContractNumber(contractNumber);
        if(exists){
            return ApiResponse.<Boolean>builder().data(true).code(200L).build();
        }

        return ApiResponse.<Boolean>builder().data(false).code(205L).build();
    }
}
