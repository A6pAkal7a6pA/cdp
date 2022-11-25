package com.mkuleshov.service.api.impl;

import com.mkuleshov.dto.BankCard;
import com.mkuleshov.dto.Subscription;
import com.mkuleshov.dto.User;
import com.mkuleshov.service.api.Service;

import java.util.List;
import java.util.Optional;

public class CloudServiceImpl implements Service {
    @Override
    public void subscribe(BankCard bankCard) {

    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cartNumber) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
