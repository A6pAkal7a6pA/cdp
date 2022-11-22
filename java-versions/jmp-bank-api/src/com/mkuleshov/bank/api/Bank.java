package com.mkuleshov.bank.api;

import com.mkuleshov.dto.BankCard;
import com.mkuleshov.dto.BankCardType;
import com.mkuleshov.dto.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}
