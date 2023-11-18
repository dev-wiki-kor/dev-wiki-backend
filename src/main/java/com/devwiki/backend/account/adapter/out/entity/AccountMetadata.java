package com.devwiki.backend.account.adapter.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Getter
@Table(name = "account_metadata")
@SQLDelete(sql = "UPDATE account_metadata SET deleted = true WHERE account_metadata_id = ?")
@Where(clause = "deleted = false")
@NoArgsConstructor
public class AccountMetadata {
    @Id
    @Column(name = "account_metadata_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nickname;

    private String profileUrl;

    private String pageUrl;

    private String accessToken;

    private boolean deleted = Boolean.FALSE; // 삭제 여부 기본값

    private AccountMetadata(String email, String nickname, String profileUrl, String pageUrl, String accessToken){
        this.id=null;
        this.email = email;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
        this.pageUrl = pageUrl;
        this.accessToken = accessToken;
    }

    public static AccountMetadata of(
            String email,
            String nickname,
            String profileUrl,
            String pageUrl,
            String accessToken
    ) {
        return new AccountMetadata(
                Objects.requireNonNull(email),
                Objects.requireNonNull(nickname),
                Objects.requireNonNull(profileUrl),
                Objects.requireNonNull(pageUrl),
                Objects.requireNonNull(accessToken)
        );
    }


}
