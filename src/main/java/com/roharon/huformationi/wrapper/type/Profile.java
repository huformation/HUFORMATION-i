package com.roharon.huformationi.wrapper.type;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Profile {
    private String nickname;
    private String imageUrl;
}
