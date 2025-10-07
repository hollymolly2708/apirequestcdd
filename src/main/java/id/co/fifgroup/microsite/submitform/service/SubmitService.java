package id.co.fifgroup.microsite.submitform.service;

import id.co.fifgroup.microsite.submitform.model.entity.WsTestContract;
import id.co.fifgroup.microsite.submitform.model.request.WsTestContractRequest;
import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;

public interface SubmitService {
     ApiResponse<String> submit(WsTestContractRequest contract);
}
