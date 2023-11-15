package com.nutech.api.controller;

import com.nutech.api.dto.BannerDto;
import com.nutech.api.dto.ServiceDto;
import com.nutech.api.model.Banner;
import com.nutech.api.model.Service;
import com.nutech.api.model.response.HttpResponseModel;
import com.nutech.api.repository.BannerRepository;
import com.nutech.api.repository.ServiceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@Tag(name = "2.Module Information")
public class InformationController {
    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Operation(description = "Information list Banner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request Successfully"),
            @ApiResponse(responseCode = "400", description = "Status code 4001 in the response means registration failed")
    })
    @GetMapping("/banner")
    public HttpResponseModel<List<BannerDto>> getBanners() {
        HttpResponseModel<List<BannerDto>> result = new HttpResponseModel<>();

        Iterable<Banner> bannersIterable = bannerRepository.findAll();

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
    @Operation(description = "Information list Service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request Successfully"),
            @ApiResponse(responseCode = "400", description = "Status code 4001 in the response means registration failed")
    })
    @GetMapping("/service")
    public HttpResponseModel<List<ServiceDto>> getServices() {
        HttpResponseModel<List<ServiceDto>> result = new HttpResponseModel<>();

        Iterable<Service> servicesIterable = serviceRepository.findAll();

        List<Service> serviceList = new ArrayList<>();
        servicesIterable.forEach(serviceList::add);

        List<ServiceDto> serviceDtos = serviceList.stream()
                .map(service -> new ServiceDto(
                        service.getService_code(),
                        service.getService_name(),
                        service.getService_icon(),
                        String.valueOf(service.getService_tariff())
                ))
                .collect(Collectors.toList());

        result.setStatus(0);
        result.setMessage("Sukses");
        result.setData(serviceDtos);

        return result;
    }
}
