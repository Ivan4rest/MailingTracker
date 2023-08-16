package com.mailingtracker.entities;

import com.mailingtracker.enums.MailingType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "mailings")
public class Mailing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MailingType type;

    private int recipientIndex;

    private String recipientAddress;

    private String recipientName;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "mailing")
    private Set<MailingEvent> mailingEvents;

    public Mailing() {
    }

    public Mailing(Long id, MailingType type, int recipientIndex, String recipientAddress, String recipientName) {
        this.id = id;
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
    }

    public Long getId() {
        return id;
    }

    public MailingType getType() {
        return type;
    }

    public void setType(MailingType type) {
        this.type = type;
    }

    public int getRecipientIndex() {
        return recipientIndex;
    }

    public void setRecipientIndex(int recipientIndex) {
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

    public Set<MailingEvent> getMailingEvents() {
        return mailingEvents;
    }

    public void setMailingEvents(Set<MailingEvent> mailingEvents) {
        this.mailingEvents = mailingEvents;
    }
}
