package com.roharon.huformationi.wrapper.payload;

import com.roharon.huformationi.wrapper.type.Block;
import com.roharon.huformationi.wrapper.type.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@ToString
public class UserRequest{

    public Block block;
    public User user;
    public Map<String, String> params;

    private String timezone;
    private String utterance;
    private String lang;

}
