package id.co.fifgroup.microsite.submitform.service;

import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface ContractService {
    public ApiResponse<Boolean> contractValidation(String contractNumber);

}
