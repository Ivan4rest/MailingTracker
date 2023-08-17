package com.mailingtracker.controllers;

import com.mailingtracker.dto.MailingDTO;
import com.mailingtracker.services.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mailings")
public class MailingController {

    private MailingService mailingService;

    public MailingService getMailingService() {
        return mailingService;
    }

    @Autowired
    public void setMailingService(MailingService mailingService) {
        this.mailingService = mailingService;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody MailingDTO mailingDTO){
        try{
            getMailingService().add(mailingDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{mailingId}/arrived/{postOfficeId}")
    public ResponseEntity<?> arrived(@PathVariable Long mailingId, @PathVariable Long postOfficeId){
        try{
            getMailingService().arrived(mailingId, postOfficeId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{mailingId}/left/{postOfficeId}")
    public ResponseEntity<?> left(@PathVariable Long mailingId, @PathVariable Long postOfficeId){
        try{
            getMailingService().left(mailingId, postOfficeId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
