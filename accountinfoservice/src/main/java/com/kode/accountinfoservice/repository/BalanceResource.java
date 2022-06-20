package com.kode.accountinfoservice.repository;

import com.kode.accountinfoservice.dto.AccountBalanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BalanceResource {

    @Autowired
    private DiscoveryClient discoveryClient;

    public AccountBalanceDTO findByAccountId(Long accountId) {
        final RestTemplate restTemplate = new RestTemplate();
        final ParameterizedTypeReference<AccountBalanceDTO> responseType = new ParameterizedTypeReference<>() {};

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("accountbalanceservice");
        if (serviceInstances.isEmpty()) {
            throw new RuntimeException("No instances of service 'balance' available!");
        }
        //just take the first one for simplicity
        ServiceInstance instance = serviceInstances.get(0);
        String url = instance.getUri().toString() + String.format("/v1/accounts/%d/balance", accountId);

        ResponseEntity<AccountBalanceDTO> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            //some exc
            throw new RuntimeException("Everything is bad!");
        }
    }
}
