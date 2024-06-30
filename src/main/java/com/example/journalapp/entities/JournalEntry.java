package com.example.journalapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JournalEntry {

    private String id;
    private String title;
    private String content;

}
