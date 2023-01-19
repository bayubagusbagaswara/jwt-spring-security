package com.bayu.jwt.model.token;

import com.bayu.jwt.model.TokenStatus;
import com.bayu.jwt.model.User;
import com.bayu.jwt.model.audit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.time.Instant;

@Entity
@Table(name = "email_verification_token", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"token"}, name = "email_verification_token_unique")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerificationToken extends DateAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_token_seq")
    private Long id;

    @Column(name = "token", nullable = false)
    private String token;

    // relational between User
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "email_verification_token_user_id"),
            referencedColumnName = "id")
    private User user;

    @Column(name = "token_status")
    @Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;

    public void setConfirmedStatus() {
        setTokenStatus(TokenStatus.STATUS_CONFIRMED);
    }


}
