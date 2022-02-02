package org.tibron.cccrediteservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tibron.cccrediteservice.domain.CreditInformationDTO;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/credit/")

public class CreditRestConctroller {
    public static final String API = "/v1/api/credit";

    @GetMapping({"","/"})
    public ResponseEntity deafultMapping(){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @GetMapping({"{uuid}"})
    public ResponseEntity<CreditInformationDTO> getCreditIformation(){
        CreditInformationDTO stubValue = CreditInformationDTO.builder().credit_uuid(UUID.randomUUID()).credit_institution("Solid as Rock Bank").credit_yearly_rate(BigDecimal.valueOf(0.0199)).build();
        return new ResponseEntity<>(stubValue, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<CreditInformationDTO> createCretitInformation(@RequestBody CreditInformationDTO inbody){
        // do not allow user to create new entries -> return entity from post request
        return new ResponseEntity<>(inbody, HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("{uuid}")
    public ResponseEntity<CreditInformationDTO> updateCreditInformation(@RequestBody CreditInformationDTO updateCreditInformationValue){
        // user not allowed updating values
        return new ResponseEntity<>(updateCreditInformationValue,HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("{uuid}")
    public ResponseEntity updateCreditInformation() {
        // user not allowed deleting values
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}
