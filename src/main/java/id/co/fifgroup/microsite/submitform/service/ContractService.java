package id.co.fifgroup.microsite.submitform.service;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestContract;
import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.model.response.WsTestContractResponse;


public interface ContractService {
    public ApiResponse<Boolean> contractValidation(String contractNumber);

    public ApiResponse<WsTestContractResponse> detailContract(String contractNumber);

}
