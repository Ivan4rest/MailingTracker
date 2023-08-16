package com.mailingtracker.repositories;

import com.mailingtracker.entities.MailingEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailingEventRepository extends CrudRepository<MailingEvent, Long> {
}
