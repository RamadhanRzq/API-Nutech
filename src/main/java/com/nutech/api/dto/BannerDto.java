package com.nutech.api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BannerDto {
    private String banner_name;
    private String banner_image;
    private String description;

    public BannerDto(int id, String bannerName, String bannerImage, String description) {
    }

}
