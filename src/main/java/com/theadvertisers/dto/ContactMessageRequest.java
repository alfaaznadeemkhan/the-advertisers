package com.theadvertisers.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactMessageRequest {
    private String name;
    private String email;
    private String phone;
    private String service;
    private String message;
}
