package com.Alpha.TeachFlow.Controller;
//here request will come of the user

import com.Alpha.TeachFlow.Services.RequestService;
import com.Alpha.TeachFlow.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Component
public class RequestController {
    @Autowired
    RequestService RequestService;

    @PostMapping(value = "/saveUserData")
    public Request saveUserData(@RequestBody Request request) {

        //service ma request save karvanin method banav
        return  RequestService.createRequest(request.getRequestId(), request.getSchoolName(), request.getSchoolCode(),
                request.getAddress(), request.getCity(), request.getState(), request.getPincode(),
                request.getEmail(), request.getPhone(), request.getAltPhone(), request.getPrincipalName(),
                request.getAdminEmail(), request.getAdminPhone(), request.getProofDocument());
    }
}
