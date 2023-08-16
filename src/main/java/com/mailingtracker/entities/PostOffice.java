package com.mailingtracker.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "post_offices")
public class PostOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int index;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "postOffice")
    private Set<MailingEvent> mailingEvents;

    public PostOffice() {
    }

    public PostOffice(Long id, int index, String name) {
        this.id = id;
        this.index = index;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MailingEvent> getMailingEvents() {
        return mailingEvents;
    }

    public void setMailingEvents(Set<MailingEvent> mailingEvents) {
        this.mailingEvents = mailingEvents;
    }
}
