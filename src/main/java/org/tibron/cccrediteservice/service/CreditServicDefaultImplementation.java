package org.tibron.cccrediteservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tibron.cccrediteservice.domain.CreditInformationDTO;
import org.tibron.cccrediteservice.mapper.CreditInformationMapper;
import org.tibron.cccrediteservice.repositories.CreditInfoRepostory;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditServicDefaultImplementation implements CreditService {

    private final CreditInfoRepostory creditInformationRepository;
    private final CreditInformationMapper creditInformationMapper;

    @Override
    public CreditInformationDTO getById(Integer id) {
        return creditInformationMapper.ccInfoToDTO(creditInformationRepository.getById(id));
    }

    @Override
    public CreditInformationDTO getByUUID(UUID uuid) {
        return creditInformationMapper.ccInfoToDTO(creditInformationRepository.findByCreditInstitutionUuid(uuid));
    }
}
