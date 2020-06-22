package com.roharon.huformationi.domain.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length=500)
    private String userKey;

    @Column(length=10)
    private String campus;
}
