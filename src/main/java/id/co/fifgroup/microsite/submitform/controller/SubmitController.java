package id.co.fifgroup.microsite.submitform.controller;

import id.co.fifgroup.microsite.submitform.model.request.WsTestContractRequest;
import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class SubmitController {
    @Autowired
    private SubmitService submitService;

    @PostMapping("/submit")
    public ApiResponse<String> submit(@RequestBody WsTestContractRequest request) {
        return submitService.submit(request);

    }
}
