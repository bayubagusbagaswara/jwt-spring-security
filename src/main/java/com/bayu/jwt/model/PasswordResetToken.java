package com.bayu.jwt.model;

import com.bayu.jwt.model.audit.DateAudit;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "password_reset_token", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"token"}, name = "password_reset_token_unique")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetToken extends DateAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pwd_reset_toke_seq")
    @SequenceGenerator(name = "pwd_reset_token_seq", allocationSize = 1)
    private Long id;

    @NaturalId
    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;

    // relational between User
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "is_active", nullable = false)
    private Boolean active;

    @Column(name = "is_claimed", nullable = false)
    private Boolean claimed;

    public PasswordResetToken(Long id, String token, Instant expiryDate, User user) {
        this.id = id;
        this.token = token;
        this.expiryDate = expiryDate;
        this.user = user;
    }

}
