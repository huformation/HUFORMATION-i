package com.roharon.huformationi.webservice.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userkey;

    @Column
    private String campus;
}
