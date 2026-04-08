package com.noobsmoke.wutangspring.dto;

public record RandomNameResponseDTO(
        String firstName,
        String secondName,
        String titleName,
        String fullName,
        String imageUrl
) {
}
