package com.mailingtracker.dto;

import com.mailingtracker.enums.MailingType;

public class MailingDTO {
    private Long id;

    private MailingType type;

    private String recipientIndex;

    private String recipientAddress;

    private String recipientName;

    public MailingDTO() {
    }

    public MailingDTO(Long id, MailingType type, String recipientIndex, String recipientAddress, String recipientName) {
        this.id = id;
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MailingType getType() {
        return type;
    }

    public void setType(MailingType type) {
        this.type = type;
    }

    public String getRecipientIndex() {
        return recipientIndex;
    }

    public void setRecipientIndex(String recipientIndex) {
        this.recipientIndex = recipientIndex;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
}
