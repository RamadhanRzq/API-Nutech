package com.nutech.api.controller;

import com.nutech.api.dto.UserDto;
import com.nutech.api.exception.UserAlreadyExistsException;
import com.nutech.api.model.User;
import com.nutech.api.model.request.RegistrationRequest;
import com.nutech.api.model.response.HttpResponseModel;
import com.nutech.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	@Autowired private UserRepository repo;
	@Autowired PasswordEncoder encoder;
	
	@Operation(summary = "Register new user", description = "Registering for new user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfull registration"),
			@ApiResponse(responseCode = "400", description = "Status code 4001 in the response means registration failed")
	})
	@PostMapping("/registration")
	public HttpResponseModel<UserDto> register(@RequestBody RegistrationRequest req) {
		HttpResponseModel<UserDto> result = new HttpResponseModel<UserDto>();
		User user = repo.findByEmail(req.getEmail());
		if (user==null) {
			// User belum ada, lanjutkan
			repo.save(User.builder()
					.email(req.getEmail())
					.first_name(req.getFirst_name())
					.last_name(req.getLast_name())
					.password(encoder.encode(req.getPassword()))
					.build());
			
			UserDto resp = UserDto.builder()
					.email(req.getEmail())
					.first_name(req.getFirst_name())
					.last_name(req.getLast_name())
					.build();
			
			result.setStatus(0);
			result.setMessage("Registrasi berhasil silahkan login");
			result.setData(resp);
		} else {
			// User sudah ada, throw Exception
			throw new UserAlreadyExistsException(req.getEmail());
		}
		return result;
	}
}
