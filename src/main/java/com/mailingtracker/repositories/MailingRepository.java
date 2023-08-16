package com.mailingtracker.repositories;

import com.mailingtracker.entities.Mailing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailingRepository extends CrudRepository<Mailing, Long> {
}
