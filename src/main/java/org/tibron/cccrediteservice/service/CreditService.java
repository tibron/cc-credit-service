package org.tibron.cccrediteservice.service;

import org.tibron.cccrediteservice.domain.CreditInformationDTO;

import java.util.UUID;

public interface CreditService {
    public CreditInformationDTO getById(Integer id);
    public CreditInformationDTO getByUUID(UUID uuid);
}
