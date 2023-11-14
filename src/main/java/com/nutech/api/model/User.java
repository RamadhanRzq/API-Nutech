package com.nutech.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "table_user")
public class User {
	@Id
	private Integer id;
	
	@Column("EMAIL")
	private String email;
	
	@Column("FIRSTNAME")
	private String first_name;
	
	@Column("LASTNAME")
	private String last_name;

	@Column("PASSWORD")
	private String password;
}
