package com.huynhcanh.accountservice.repository;

import com.huynhcanh.accountservice.data.Account;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AccountRepository extends R2dbcRepository<Account,String> {
}
