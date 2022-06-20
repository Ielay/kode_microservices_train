package com.kode.accountinfoservice.service;

import com.kode.accountinfoservice.domain.AccountInfo;
import com.kode.accountinfoservice.repository.BalanceResource;
import com.kode.accountinfoservice.repository.CardResource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService {

    @Autowired
    private CardResource cardResource;

    @Autowired
    private BalanceResource balanceResource;

    public Single<AccountInfo> getAccountInfoById(Long accountId) {
        //verify if such account really exists before making next requests
        //...

        return Single.zip(
            Single.fromCallable(() -> cardResource.findAllByAccountId(accountId)).subscribeOn(Schedulers.io()),
            Single.fromCallable(() -> balanceResource.findByAccountId(accountId)).subscribeOn(Schedulers.io()),
            (foundCards, foundBalance) -> {
                AccountInfo accountInfo = new AccountInfo();
                accountInfo.setAccountId(accountId);
                accountInfo.setCards(foundCards);
                accountInfo.setBalance(foundBalance);

                return accountInfo;
            }
        );
    }
}
