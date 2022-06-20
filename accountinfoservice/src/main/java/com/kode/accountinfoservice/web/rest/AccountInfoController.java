package com.kode.accountinfoservice.web.rest;

import com.kode.accountinfoservice.domain.AccountInfo;
import com.kode.accountinfoservice.service.AccountInfoService;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping("/{accountId}/info")
    public Single<ResponseEntity<AccountInfo>> getAccountInfo(@PathVariable Long accountId) {
        return accountInfoService.getAccountInfoById(accountId)
            .subscribeOn(Schedulers.io())
            .map(result -> ResponseEntity.ok().body(result));
    }
}
