package com.roharon.huformationi.webservice.users;

import com.roharon.huformationi.wrapper.type.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Builder
public class Users{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userkey;

    @Column
    private String campus;

    public Users(String userkey, String campus) {
        this.userkey = userkey;
        this.campus = campus;
    }
}
