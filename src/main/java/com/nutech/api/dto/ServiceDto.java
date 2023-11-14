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
    private int service_tariff;

    public ServiceDto( String service_code, String service_name, String service_icon, String service_tariff) {
        this.service_code = service_code;
        this.service_name = service_name;
        this.service_icon = service_icon;
        this.service_tariff = Integer.parseInt(service_tariff);
    }


}
