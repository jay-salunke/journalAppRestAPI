package com.example.journalapp.service.impl;


import com.example.journalapp.entities.JournalEntry;
import com.example.journalapp.exception.ResourceNotFoundException;
import com.example.journalapp.payloads.JournalEntryDTO;
import com.example.journalapp.service.JournalEntryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {


    private HashMap<String, JournalEntry> journalEntries = new HashMap<>();
    @Autowired
    ModelMapper modelMapper;

    final String JOURNAL_CONSTANT = "journal";




    @Override
    public JournalEntryDTO getJournal(String id) {
            if(!journalEntries.containsKey(id)){
                throw new ResourceNotFoundException(JOURNAL_CONSTANT,"id",id);
            }
            return modelMapper.map(journalEntries.get(id),JournalEntryDTO.class);
        }


    @Override
    public List<JournalEntryDTO> getJournals() {

        return  journalEntries.
                values().
                stream().
                map(x->modelMapper.map(x,JournalEntryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public JournalEntryDTO addJournal(JournalEntryDTO journalEntryDTO) {
        String id =UUID.randomUUID().toString();
        JournalEntry journal = modelMapper.map(journalEntryDTO,JournalEntry.class);
        journal.setId(id);
        journalEntries.put(id,journal);

        return modelMapper.map(journal,JournalEntryDTO.class);
    }

    @Override
    public JournalEntryDTO updateJournal(JournalEntryDTO journalEntryDTO,String id) {

        if(!journalEntries.containsKey(id)){
            throw new ResourceNotFoundException(JOURNAL_CONSTANT,"id",id);
        }
        journalEntries.put(id,modelMapper.map(journalEntryDTO,JournalEntry.class));
        return journalEntryDTO;
    }

    @Override
    public void deleteJournal(String id) {
        if(!journalEntries.containsKey(id)){
            throw  new ResourceNotFoundException(JOURNAL_CONSTANT,"id",id);
        }
        journalEntries.remove(id);
    }
}
