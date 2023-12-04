package com.example.ItemOrderUser.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLER_GUEST","손님"),
    USER("ROLE_USER","사용자");


    private final String key;
    private final String title;
}
