package com.Alpha.TeachFlow.Services;

import com.Alpha.TeachFlow.Repository.RequestRepo;
import com.Alpha.TeachFlow.Repository.RequestRepo;
import com.Alpha.TeachFlow.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@Component
public class RequestService {
    @Autowired
    private RequestRepo requestRepo;

    public Request createRequest(Long requestId, String schoolName, String schoolCode,
                                 String address, String city, String state, String pincode, String email, String phone,
                                 String altPhone, String principalName, String adminEmail, String adminPhone,
                                 String proofDocument)
    {
        Request request = new Request(); // Create a new instance
        request.setRequestId(requestId);
        request.setSchoolName(schoolName);
        request.setSchoolCode(schoolCode);
        request.setAddress(address);
        request.setCity(city);
        request.setState(state);
        request.setPincode(pincode);
        request.setEmail(email);
        request.setPhone(phone);
        request.setAltPhone(altPhone);
        request.setPrincipalName(principalName);
        request.setAdminEmail(adminEmail);
        request.setAdminPhone(adminPhone);
        request.setProofDocument(proofDocument);

        return requestRepo.save(request); // Save the request to the database
    }
}
