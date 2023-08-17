package com.mailingtracker.services;

import com.mailingtracker.dto.MailingDTO;
import com.mailingtracker.entities.Mailing;
import com.mailingtracker.entities.MailingEvent;
import com.mailingtracker.entities.PostOffice;
import com.mailingtracker.enums.EventType;
import com.mailingtracker.repositories.MailingEventRepository;
import com.mailingtracker.repositories.MailingRepository;
import com.mailingtracker.repositories.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class MailingService {

    private MailingRepository mailingRepository;
    private MailingEventRepository mailingEventRepository;
    private PostOfficeRepository postOfficeRepository;

    public MailingRepository getMailingRepository() {
        return mailingRepository;
    }

    @Autowired
    public void setMailingRepository(MailingRepository mailingRepository) {
        this.mailingRepository = mailingRepository;
    }

    public MailingEventRepository getMailingEventRepository() {
        return mailingEventRepository;
    }

    @Autowired
    public void setMailingEventRepository(MailingEventRepository mailingEventRepository) {
        this.mailingEventRepository = mailingEventRepository;
    }

    public PostOfficeRepository getPostOfficeRepository() {
        return postOfficeRepository;
    }

    @Autowired
    public void setPostOfficeRepository(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    @Transactional
    public void add(MailingDTO mailingDTO){
        getMailingRepository().save(new Mailing(mailingDTO.getType(), mailingDTO.getRecipientIndex(), mailingDTO.getRecipientAddress(), mailingDTO.getRecipientName()));
    }

    @Transactional
    public void arrived(Long mailingId, Long postOfficeId){
        Mailing mailing = getMailingRepository().findById(mailingId).get();
        PostOffice postOffice = getPostOfficeRepository().findById(postOfficeId).get();
        getMailingEventRepository().save(new MailingEvent(new Date(), mailing.getRecipientIndex().equals(postOffice.getIndex()) ? EventType.RECEIVED :EventType.ARRIVED, mailing, postOffice));
    }

    @Transactional
    public void left(Long mailingId, Long postOfficeId){
        Mailing mailing = getMailingRepository().findById(mailingId).get();
        PostOffice postOffice = getPostOfficeRepository().findById(postOfficeId).get();
        getMailingEventRepository().save(new MailingEvent(new Date(), EventType.LEFT, mailing, postOffice));
    }
}
