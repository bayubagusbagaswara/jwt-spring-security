package com.bayu.jwt.model;

import com.bayu.jwt.model.audit.DateAudit;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

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

}
