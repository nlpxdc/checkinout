package io.cjf.mobileoa.checkinout.controller;

import io.cjf.mobileoa.checkinout.vo.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Value("${checkInOut.longitude}")
    private Double longitude;

    @Value("${checkInOut.latitude}")
    private Double latitude;

    @GetMapping("/getCheckInOutLocation")
    public Location getCheckInOutLocation(){
        Location location = new Location();
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        return  location;
    }
}
