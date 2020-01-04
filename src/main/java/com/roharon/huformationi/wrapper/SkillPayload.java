package com.roharon.huformationi.wrapper;

import com.roharon.huformationi.wrapper.payload.Action;
import com.google.gson.Gson;
import com.roharon.huformationi.wrapper.payload.Bot;
import com.roharon.huformationi.wrapper.payload.Intent;
import com.roharon.huformationi.wrapper.payload.UserRequest;
import lombok.*;

import java.util.List;

@Getter
@ToString
public class SkillPayload{

    public UserRequest userRequest;
    public Intent intent;

    public Bot bot;
    public Action action;
}

