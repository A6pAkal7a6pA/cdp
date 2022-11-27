package com.mkuleshov.app;

import com.mkuleshov.bank.api.Bank;
import com.mkuleshov.cloud.bank.impl.CloudBankImpl;
import com.mkuleshov.dto.BankCard;
import com.mkuleshov.dto.BankCardType;
import com.mkuleshov.dto.User;
import com.mkuleshov.service.api.Service;
import com.mkuleshov.service.api.exception.BankCardException;

import java.time.LocalDate;
import java.util.ServiceLoader;

public class Demo {
    public static void main(String[] args) {
        User max = new User("Max", "SurnameMax", LocalDate.of(2003, 2, 10));
        User araz = new User("Araz", "SurnameAraz", LocalDate.of(2000, 3, 21));
        User alexey = new User("Alex", "SurnameAlex", LocalDate.of(2005, 4, 15));


        Bank bank = new CloudBankImpl();
        BankCard maxCard = bank.createBankCard(max, BankCardType.DEBIT);
        BankCard alexeyCard = bank.createBankCard(alexey, BankCardType.CREDIT);
        BankCard arazCard = bank.createBankCard(araz, BankCardType.DEBIT);

        Service service = ServiceLoader.load(Service.class)
                .findFirst()
                .get();

        service.subscribe(maxCard);
        service.subscribe(alexeyCard);
        service.subscribe(arazCard);

        System.out.println("All users: " + service.getAllUsers());
        System.out.println("Max card: " + service.getSubscriptionByBankCardNumber(maxCard.getNumber()).orElseThrow(BankCardException::new));
        System.out.println("Araz card: " + service.getSubscriptionByBankCardNumber(arazCard.getNumber()).orElseThrow(BankCardException::new));
        System.out.println("Alexey card: " + service.getSubscriptionByBankCardNumber(alexeyCard.getNumber()).orElseThrow(BankCardException::new));
        System.out.println("Average years: " + service.getAverageUsersAge());
        System.out.println("Is Max playable: " + Service.isPayableUser(max));
        System.out.println("Is Araz playable: " + Service.isPayableUser(araz));
        System.out.println("Is Alexey playable: " + Service.isPayableUser(alexey));
        System.out.println("Get subscription where bank card has number 11: " +
                service.getAllSubscriptionsByCondition(subscription -> subscription.getBankcard().contains("11")));
    }
}
