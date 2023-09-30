package com.chethiya.application.dao.repositoryies;

import com.chethiya.application.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

    Position getPositionByReferenceId(String referenceId);

}
