package com.theadvertisers.controller;

import com.theadvertisers.dto.ContactMessageRequest;
import com.theadvertisers.entity.ContactMessage;
import com.theadvertisers.repository.ContactMessageRepository;
import com.theadvertisers.service.TheAdvertisersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/data")
@CrossOrigin // important for frontend hosted separately
public class DataController {

    @Autowired
    private TheAdvertisersService theAdvertisersService;

    @PostMapping("/submitContactMessage")
    public ResponseEntity<?> submitContactMessage(
            @RequestBody ContactMessageRequest request
    ) {

        theAdvertisersService.saveContactMessage(request);

        return ResponseEntity.ok(
                Map.of(
                        "status", "success",
                        "message", "Thank you! Your message has been sent successfully."
                )
        );
    }

}
