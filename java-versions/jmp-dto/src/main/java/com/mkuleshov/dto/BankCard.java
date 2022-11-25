package com.mkuleshov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankCard {
    private String number;
    private User user;

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }
}
