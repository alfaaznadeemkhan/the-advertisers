package com.theadvertisers.serviceImpl;

import com.theadvertisers.dto.ContactMessageRequest;
import com.theadvertisers.entity.ContactMessage;
import com.theadvertisers.repository.ContactMessageRepository;
import com.theadvertisers.service.TheAdvertisersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class TheAdvertisersServiceImpl implements TheAdvertisersService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @Override
    public void saveContactMessage(ContactMessageRequest request) {

        ContactMessage entity = ContactMessage.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .message(request.getMessage())
                .service(request.getService())
                .createdAt(LocalDateTime.now())
                .build();

        contactMessageRepository.save(entity);
    }


}
