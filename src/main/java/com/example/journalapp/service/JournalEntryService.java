package com.example.journalapp.service;
import com.example.journalapp.payloads.JournalEntryDTO;

import java.util.List;

public interface JournalEntryService {

    public JournalEntryDTO getJournal(String id);
    public List<JournalEntryDTO> getJournals();

    public JournalEntryDTO addJournal(JournalEntryDTO journalEntryDTO);

    public JournalEntryDTO updateJournal(JournalEntryDTO journalEntryDTO,String id);

    public void deleteJournal(String id);
}
