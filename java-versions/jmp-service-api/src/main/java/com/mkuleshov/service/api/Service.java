package com.mkuleshov.service.api;

import com.mkuleshov.dto.BankCard;
import com.mkuleshov.dto.Subscription;
import com.mkuleshov.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {
    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String cartNumber);
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate);

    List<User> getAllUsers();

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .mapToLong(user -> user.getBirthday()
                        .until(LocalDate.now())
                        .get(ChronoUnit.YEARS))
                .average()
                .getAsDouble();
    }

    static boolean isPayableUser(User user) {
        return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) > 18;
    }

}
