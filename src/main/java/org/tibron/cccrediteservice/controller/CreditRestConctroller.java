package org.tibron.cccrediteservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tibron.cccrediteservice.domain.CreditInformationDTO;
import org.tibron.cccrediteservice.service.CreditService;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/credit/")
@RequiredArgsConstructor
public class CreditRestConctroller {
    public static final String API = "/v1/api/credit/";
    public final CreditService service;

    @GetMapping({"","/"})
    public ResponseEntity deafultMapping(){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping({"id/{id}"})
    public ResponseEntity<CreditInformationDTO> getCreditIformation(@PathVariable(name = "id") Integer id){
        CreditInformationDTO byId = service.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping({"uuid/{uuid}"})
    public ResponseEntity<CreditInformationDTO> getCreditIformation(@PathVariable(name = "uuid") UUID uuid){
        CreditInformationDTO byUUID = service.getByUUID(uuid);
        return new ResponseEntity<>(byUUID, HttpStatus.OK);
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
