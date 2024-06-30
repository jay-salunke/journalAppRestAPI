package com.example.journalapp.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIResponse {
    String message;
    boolean status;
    String httpStatus;

}
