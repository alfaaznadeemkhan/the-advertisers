package com.theadvertisers.service;

import com.theadvertisers.dto.ContactMessageRequest;
import com.theadvertisers.entity.ContactMessage;

public interface TheAdvertisersService {

    void saveContactMessage(ContactMessageRequest request);
}
