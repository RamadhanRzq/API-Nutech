package com.nutech.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDto {
    private String service_code;
    private String service_name;
    private String service_icon;
    private String service_tariff;

    public ServiceDto(int id, String service_code, String service_name, String service_icon, String service_tariff){

    }
}
