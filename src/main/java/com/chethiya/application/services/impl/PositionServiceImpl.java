package com.chethiya.application.services.impl;

import com.chethiya.application.dao.repositoryies.PositionRepository;
import com.chethiya.application.dto.PositionDTO;
import com.chethiya.application.model.Position;
import com.chethiya.application.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public PositionDTO saveEntity(PositionDTO positionDTO) {
        Position position = positionRepository.save(getPosition(positionDTO, new Position()));
        return getPositionDTO(positionRepository.save(position));
    }

    @Override
    public PositionDTO getEntity(String refId) {
        return getPositionDTO(positionRepository.getPositionByReferenceId(refId));
    }

    @Override
    public PositionDTO updateEntity(PositionDTO positionDTO) {
        Position existingPosition = positionRepository.getPositionByReferenceId(positionDTO.getReferenceId());
        Position position = positionRepository.save(getPosition(positionDTO, existingPosition));
        return getPositionDTO(positionRepository.save(position));
    }

    private PositionDTO getPositionDTO(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionName(position.getPositionName());
        positionDTO.setReferenceId(position.getReferenceId());
        positionDTO.setMonthlySalary(position.getMonthlySalary());
        positionDTO.setTypeOfWork(position.getTypeOfWork());
        positionDTO.setStartDate(position.getStartDate());
        positionDTO.setEndDate(position.getEndDate());
        return positionDTO;
    }

    private Position getPosition(PositionDTO positionDTO, Position position) {
        position.setPositionName(positionDTO.getPositionName());
        position.setReferenceId(positionDTO.getReferenceId());
        position.setMonthlySalary(positionDTO.getMonthlySalary());
        position.setTypeOfWork(positionDTO.getTypeOfWork());
        position.setStartDate(positionDTO.getStartDate());
        position.setEndDate(positionDTO.getEndDate());
        return position;
    }
}
