package com.mkuleshov.dto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankCard {
    private String number;
    private User user;

    public BankCard() {
    }

    public BankCard(User user) {
        this.number = generateCard();
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String generateCard() {
        return IntStream.rangeClosed(1, 16)
                .mapToObj(i -> String.valueOf((int) Math.floor(1 + Math.random() * 9)))
                .collect(Collectors.joining());
    }
}
