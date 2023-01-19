package com.bayu.jwt.model.token;

import com.bayu.jwt.model.UserDevice;
import com.bayu.jwt.model.audit.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "refresh_token", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"token"}, name = "refresh_token_unique")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends DateAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresh_token_seq")
    @SequenceGenerator(name = "refresh_token_seq", allocationSize = 1)
    private Long id;

    @Column(name = "token", nullable = false)
    private String token;

    // relational one to one between UserDevice
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_device_id", unique = true)
    private UserDevice userDevice;

    @Column(name = "refresh_count")
    private Long refreshCount;

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;

    public RefreshToken(Long id, String token, UserDevice userDevice, Long refreshCount, Instant expiryDate) {
        this.id = id;
        this.token = token;
        this.userDevice = userDevice;
        this.refreshCount = refreshCount;
        this.expiryDate = expiryDate;
    }

    public void incrementRefreshCount() {
        refreshCount = refreshCount + 1;
    }

}
