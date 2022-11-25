package com.mkuleshov.service.api;

import com.mkuleshov.dto.BankCard;
import com.mkuleshov.dto.Subscription;
import com.mkuleshov.dto.User;

import java.util.List;
import java.util.Optional;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cartNumber);
    List<User> getAllUsers();
}
