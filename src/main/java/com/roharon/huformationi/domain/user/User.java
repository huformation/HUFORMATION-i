package com.roharon.huformationi.domain.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_entity", uniqueConstraints = {@UniqueConstraint(
        name = "USER_KEY_UNIQUE", columnNames = {"userKey"}
)})
public class User {

    public enum Campus {seoul, global}

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(length=500)
    private String userKey;

    @Column(length=10)
    @Enumerated(EnumType.STRING)
    private Campus campus;


}
