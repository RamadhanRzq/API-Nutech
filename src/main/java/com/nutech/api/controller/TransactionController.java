package com.nutech.api.controller;

import com.nutech.api.model.User;
import com.nutech.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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

        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userEmail = userDetails.getUsername();

            double userBalance = retrieveUserBalance(userEmail);

            // Membuat response
            return "User: " + userEmail + ", Balance: " + userBalance;
        } else {
            // Handle the case where the principal is not of type UserDetails
            return "Error: Unable to retrieve user details.";
        }
    }
    private double retrieveUserBalance(String userEmail) {
        User user = userRepository.findByEmail(userEmail);

        if (user != null) {
            String balanceAsString = user.getBalance();
            return Double.parseDouble(balanceAsString);
        } else {
            throw new RuntimeException("User not found with email: " + userEmail);
        }
    }
}
