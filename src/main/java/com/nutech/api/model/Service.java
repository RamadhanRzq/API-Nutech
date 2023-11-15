package com.nutech.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "table_service")
public class Service {
    @Id
    private int Id;

    @Column("SERVICE_CODE")
    private String service_code;

    @Column("SERVICE_NAME")
    private String service_name;

    @Column("SERVICE_ICON")
    private String service_icon;

    @Column("SERVICE_TARIFF")
    private double service_tariff;

    public double getServiceTariff() {
        return this.service_tariff;
    }

}
