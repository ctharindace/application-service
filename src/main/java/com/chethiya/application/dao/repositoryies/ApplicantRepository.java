package com.chethiya.application.dao.repositoryies;

import com.chethiya.application.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

    Applicant findByNic(String nic);
}

