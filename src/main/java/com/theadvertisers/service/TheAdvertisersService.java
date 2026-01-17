package com.theadvertisers.service;

import com.theadvertisers.dto.ContactMessageRequest;
import com.theadvertisers.entity.ContactMessage;

import java.util.List;

public interface TheAdvertisersService {

    void saveContactMessage(ContactMessageRequest request);

    List<ContactMessage> fetchContactDetails();

    void deleteContactMessage(Long id);


}
