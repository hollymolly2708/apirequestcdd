package id.co.fifgroup.microsite.submitform.controller;

import id.co.fifgroup.microsite.submitform.model.response.ApiResponse;
import id.co.fifgroup.microsite.submitform.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping("/validate")
    public ApiResponse<Boolean> contractController(@RequestParam String contractNumber) {
        return contractService.contractValidation(contractNumber);
    }
}
