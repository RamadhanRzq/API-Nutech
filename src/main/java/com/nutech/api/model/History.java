package com.nutech.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("table_history")
public class History {
    @Id
    private Long id;

    @Column("EMAIL")
    private String email;

    @Column("TRANSACTION_DATE")
    private Date transactionDate;

}
