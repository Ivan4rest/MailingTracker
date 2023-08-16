package com.mailingtracker.repositories;

import com.mailingtracker.entities.PostOffice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOfficeRepository extends CrudRepository<PostOffice, Long> {
}
