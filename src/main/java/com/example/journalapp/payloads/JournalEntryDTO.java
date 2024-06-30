package com.example.journalapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JournalEntryDTO {

    private String id;
    private String title;
    private String content;
}
