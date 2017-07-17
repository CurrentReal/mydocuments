package com.example.demo.profile;

import org.springframework.test.annotation.ProfileValueSource;

/**
 * Created by Hyunjin on 2017-07-17.
 */
public class CustomProfile implements ProfileValueSource {

    public String get(String key) {
        if (key.equals("environment"))
            return "dev";
        else if (key.equals("os.name"))
            return "Unix";
        return null;
    }

}
