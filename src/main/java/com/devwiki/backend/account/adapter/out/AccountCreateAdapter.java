package com.devwiki.backend.account.adapter.out;

import com.devwiki.backend.account.adapter.out.entity.AccountMetadata;
import com.devwiki.backend.account.adapter.out.github.dto.GithubUserInfoResponse;
import com.devwiki.backend.account.adapter.out.repository.AccountMetadataRepository;
import com.devwiki.backend.account.application.port.out.account.AccountCreatePort;
import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountCreateAdapter implements AccountCreatePort {

    private final AccountMetadataRepository accountMetadataRepository;


    @Override
    public void createAccount(GithubUserInfoResponse githubUserInfoResponse) {
        accountMetadataRepository.save(AccountMetadata.of(
                githubUserInfoResponse.email(),
                githubUserInfoResponse.nickname(),
                githubUserInfoResponse.profileUrl(),
        ))
    }
}
