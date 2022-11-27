package com.mkuleshov.service.api.impl;

import com.mkuleshov.dto.BankCard;
import com.mkuleshov.dto.Subscription;
import com.mkuleshov.dto.User;
import com.mkuleshov.service.api.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CloudServiceImpl implements Service {
    private final Map<BankCard, Subscription> store = new HashMap<>();

    @Override
    public void subscribe(BankCard bankCard) {
        store.put(bankCard, new Subscription(bankCard.getNumber(), LocalDate.now()));
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cartNumber) {
        return store.entrySet().stream()
                .filter(entry -> entry.getKey().getNumber().equals(cartNumber))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate) {
        return store.values().stream()
                .filter(subscriptionPredicate)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<User> getAllUsers() {
        return store.keySet().stream()
                .map(BankCard::getUser)
                .collect(Collectors.toUnmodifiableList());
    }
}
