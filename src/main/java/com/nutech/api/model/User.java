package com.nutech.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "table_user")
public class User {
	@Id
	private Integer id;
	
	@Getter
	@Column("EMAIL")
	private String email;
	
	@Column("FIRSTNAME")
	private String first_name;
	
	@Column("LASTNAME")
	private String last_name;

	@Column("PASSWORD")
	private String password;
	@Column("PROFILE_IMAGE")
	private String profile_image;

}
