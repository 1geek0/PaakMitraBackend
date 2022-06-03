package com.g1ee0k.paak_mitra_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "jwt")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long token_id;

    @ManyToOne(targetEntity = User.class)
    private User userId;

    private String email;
    private String name;
    private String refreshToken;
}

