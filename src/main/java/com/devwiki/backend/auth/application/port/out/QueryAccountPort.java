package com.devwiki.backend.auth.application.port.out;

import com.devwiki.backend.auth.domain.Account;
import com.devwiki.backend.auth.domain.AccountQueryCondition;

public interface QueryAccountPort {
    Account find(AccountQueryCondition queryCondition);
}
