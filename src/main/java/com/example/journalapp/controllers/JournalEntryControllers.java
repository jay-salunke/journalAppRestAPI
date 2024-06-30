package com.example.journalapp.controllers;

import com.example.journalapp.payloads.APIResponse;
import com.example.journalapp.payloads.JournalEntryDTO;
import com.example.journalapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JournalEntryControllers {

    @Autowired
    JournalEntryService journalEntryService;

    @GetMapping("/journal/{journalId}")
    public ResponseEntity<JournalEntryDTO> getJournal(@PathVariable String journalId){
        return new ResponseEntity<>(journalEntryService.getJournal(journalId),HttpStatus.OK);
    }

    @GetMapping("/journals")
    public ResponseEntity<List<JournalEntryDTO>> getJournals(){
        return new ResponseEntity<>(journalEntryService.getJournals(),HttpStatus.OK);
    }

    @PostMapping("/journal")
    public ResponseEntity<JournalEntryDTO> addJournal(@RequestBody JournalEntryDTO journalEntryDTO){
        return new ResponseEntity<>(journalEntryService.addJournal(journalEntryDTO),HttpStatus.CREATED);
    }

    @PutMapping("/journal/{journalId}")
    public ResponseEntity<JournalEntryDTO> updateJournal(@RequestBody JournalEntryDTO journalEntryDTO,@PathVariable String journalId){
        return new ResponseEntity<>(journalEntryService.updateJournal(journalEntryDTO,journalId),HttpStatus.OK);
    }

    @DeleteMapping("journal/{journalId}")
    public ResponseEntity<APIResponse> deleteJournal(@PathVariable String journalId){
        journalEntryService.deleteJournal(journalId);
        return new ResponseEntity<>(new APIResponse("id: "+journalId+" got deleted successfully",true, HttpStatus.OK.toString()),HttpStatus.OK);
    }

}
