package org.tibron.cccrediteservice.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.tibron.cccrediteservice.domain.CreditInformationDTO;
import org.tibron.cccrediteservice.domain.CreditInfromation;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreditInformationMapper {
    CreditInformationMapper MAPPER = Mappers.getMapper(CreditInformationMapper.class );

    @Mapping(source = "creditInstitutionUuid",target = "credit_uuid")
    @Mapping(source = "creditInstitutionName", target = "credit_institution")
    @Mapping(source = "creditInstitutionYearlyRate", target = "credit_yearly_rate")
    CreditInformationDTO ccInfoToDTO(CreditInfromation ccInfo);

    @Mapping(target = "creditInstitutionUuid",source = "credit_uuid")
    @Mapping(target = "creditInstitutionName", source = "credit_institution")
    @Mapping(target = "creditInstitutionYearlyRate", source = "credit_yearly_rate")
    CreditInfromation DtotoCcInfo(CreditInformationDTO ccDto);
}
