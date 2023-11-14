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
@Table(name = "table_banner")
public class Banner {
    @Id
    private int Id;

    @Column("BANNER_NAME")
    private String banner_name;

    @Column("BANNER_IMAGE")
    private String banner_image;

    @Column("DESCRIPTION")
    private String description;

}
