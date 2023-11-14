package com.nutech.api.controller;

import com.nutech.api.config.JwtTokenUtil;
import com.nutech.api.config.MyUserDetailsService;
import com.nutech.api.dto.UserDto;
import com.nutech.api.exception.UserAlreadyExistsException;
import com.nutech.api.model.User;
import com.nutech.api.model.request.JwtRequest;
import com.nutech.api.model.request.RegistrationRequest;
import com.nutech.api.model.response.HttpResponseModel;
import com.nutech.api.model.response.JwtResponse;
import com.nutech.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tag(name = "1.Module Membership")
public class UserController {
	@Autowired private UserRepository repo;
	@Autowired PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Operation(description = "Registering for new user")
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
					.profile_image(req.getProfile_image())
					.password(encoder.encode(req.getPassword()))
					.build());
			
			UserDto resp = UserDto.builder()
					.email(req.getEmail())
					.first_name(req.getFirst_name())
					.last_name(req.getLast_name())
					.profile_image(req.getProfile_image())
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
	@Operation(description = "Login using registered email and password")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfull login will get token, and the token must be included in every request for authorization"),
			@ApiResponse(responseCode = "401", description = "Login failed")
	})
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HttpResponseModel<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		HttpResponseModel<JwtResponse> result = new HttpResponseModel<JwtResponse>();

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);

		result.setStatus(0);
		result.setMessage("Login Berhasil");
		result.setData(new JwtResponse(token));

		return result;
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	@Operation(description = "Information profile User")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Request Successfully"),
			@ApiResponse(responseCode = "400", description = "Status code 4001 in the response means registration failed")
	})
	@GetMapping("/profile")
	public HttpResponseModel<UserDto> profile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			// Dapatkan nama pengguna/email dari UserDetails
			String username = userDetails.getUsername();

			// Cari pengguna berdasarkan nama pengguna atau email
			User user = repo.findByEmail(username);

			// Memeriksa apakah pengguna ditemukan
			if (user != null) {
				// Membuat DTO dari data profil
				UserDto resp = UserDto.builder()
						.email(user.getEmail())
						.first_name(user.getFirst_name())
						.last_name(user.getLast_name())
						.profile_image(user.getProfile_image())
						.build();

				// Membuat dan mengembalikan respons
				HttpResponseModel<UserDto> result = new HttpResponseModel<>();
				result.setStatus(0);
				result.setMessage("Sukses");
				result.setData(resp);

				return result;
			}
		}

		// Pengguna tidak ditemukan, tanggapi sesuai
		HttpResponseModel<UserDto> result = new HttpResponseModel<>();
		result.setStatus(1);
		result.setMessage("Pengguna tidak ditemukan");
		return result;
	}
}
