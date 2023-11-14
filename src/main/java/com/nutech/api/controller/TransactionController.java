package com.nutech.api.controller;

import com.nutech.api.dto.BannerDto;
import com.nutech.api.model.Banner;
import com.nutech.api.model.User;
import com.nutech.api.model.response.HttpResponseModel;
import com.nutech.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@Tag(name = "3.Module Transaction")
public class TransactionController {
    @Autowired
    private UserRepository userRepository;
    @Operation(description = "Information Balance")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request Successfully"),
            @ApiResponse(responseCode = "400", description = "Status code 4001 in the response means registration failed")
    })
    @GetMapping("/balance")
    public String getBalance() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        double userBalance = retrieveUserBalance(currentUser.getEmail());

        // Membuat response
        return "User: " + currentUser.getEmail() + ", Balance: " + userBalance;
    }

    private double retrieveUserBalance(String userEmail) {
        return 1000.00;
    }
}
