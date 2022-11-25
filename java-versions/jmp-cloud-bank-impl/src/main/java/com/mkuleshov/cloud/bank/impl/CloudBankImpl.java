package com.mkuleshov.cloud.bank.impl;

import com.mkuleshov.bank.api.Bank;
import com.mkuleshov.dto.BankCard;
import com.mkuleshov.dto.BankCardType;
import com.mkuleshov.dto.CreditBankCard;
import com.mkuleshov.dto.DebitBankCard;
import com.mkuleshov.dto.User;

public class CloudBankImpl implements Bank {

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return new BankCard();

    }
}
