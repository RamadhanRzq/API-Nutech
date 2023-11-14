package com.nutech.api.controller;

import com.nutech.api.dto.BannerDto;
import com.nutech.api.dto.UserDto;
import com.nutech.api.exception.UserAlreadyExistsException;
import com.nutech.api.model.Banner;
import com.nutech.api.model.User;
import com.nutech.api.model.request.RegistrationRequest;
import com.nutech.api.model.response.HttpResponseModel;
import com.nutech.api.repository.BannerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@Tag(name = "2.Module Information")
public class InformationController {
    @Autowired
    private BannerRepository repo;

    @Operation(description = "Information list Banner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request Successfully"),
            @ApiResponse(responseCode = "400", description = "Status code 4001 in the response means registration failed")
    })
    @GetMapping("/banner")
    public HttpResponseModel<List<BannerDto>> getBanners() {
        HttpResponseModel<List<BannerDto>> result = new HttpResponseModel<>();

        Iterable<Banner> bannersIterable = repo.findAll();

        List<Banner> bannersList = new ArrayList<>();
        bannersIterable.forEach(bannersList::add);

        List<BannerDto> bannerDtos = bannersList.stream()
                .map(banner -> new BannerDto(
                        banner.getBanner_name(),
                        banner.getBanner_image(),
                        banner.getDescription()
                ))
                .collect(Collectors.toList());

        result.setStatus(0);
        result.setMessage("Sukses");
        result.setData(bannerDtos);

        return result;
    }
}