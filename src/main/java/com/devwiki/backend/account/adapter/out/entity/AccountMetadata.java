package com.devwiki.backend.account.adapter.out.entity;

import com.devwiki.backend.account.adapter.out.OauthType;
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

    private String uniqueId;
    private String email;

    private String nickname;


    private String profileUrl;

    private String pageUrl;

    @Enumerated(value = EnumType.STRING)
    private OauthType oauthType;

    private boolean deleted = Boolean.FALSE; // 삭제 여부 기본값

    private AccountMetadata(String email,String uniqueId, String nickname, String profileUrl, String pageUrl,OauthType oauthType){
        this.id=null;
        this.email = email;
        this.uniqueId = uniqueId;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
        this.pageUrl = pageUrl;
        this.oauthType = oauthType;
    }

    public static AccountMetadata of(
            String email,
            String uniqueId,
            String nickname,
            String profileUrl,
            String pageUrl,
            OauthType oauthType
    ) {
        return new AccountMetadata(
                email,
                Objects.requireNonNull(uniqueId),
                nickname,
                profileUrl,
                pageUrl,
                oauthType
        );
    }


}
