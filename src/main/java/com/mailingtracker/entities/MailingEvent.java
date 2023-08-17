package com.mailingtracker.entities;

import com.mailingtracker.enums.EventType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "mailing_events")
public class MailingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private EventType eventType;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @MapsId("mailingId")
    @JoinColumn(name = "mailing_id")
    private Mailing mailing;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @MapsId("postOfficeId")
    @JoinColumn(name = "post_office_id")
    private PostOffice postOffice;

    public MailingEvent() {
    }

    public MailingEvent(Date date, EventType eventType, Mailing mailing, PostOffice postOffice) {
        this.id = id;
        this.date = date;
        this.eventType = eventType;
        this.mailing = mailing;
        this.postOffice = postOffice;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Mailing getMailing() {
        return mailing;
    }

    public void setMailing(Mailing mailing) {
        this.mailing = mailing;
    }

    public PostOffice getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(PostOffice postOffice) {
        this.postOffice = postOffice;
    }
}
