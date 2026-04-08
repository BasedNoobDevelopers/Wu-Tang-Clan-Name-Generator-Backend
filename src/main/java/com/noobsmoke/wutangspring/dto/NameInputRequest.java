package com.noobsmoke.wutangspring.dto;

import com.noobsmoke.wutangspring.model.Gender;

public record NameInputRequest(
        String firstName,
        String lastName,
        Gender gender
) {
}
