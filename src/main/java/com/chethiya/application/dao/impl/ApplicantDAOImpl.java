package com.chethiya.application.dao.impl;

import com.chethiya.application.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantDAOImpl extends JpaRepository<Applicant, Integer> {
}
