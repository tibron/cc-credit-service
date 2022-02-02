package org.tibron.cccrediteservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreditInformationDTO {
    private UUID credit_uuid;
    private String credit_institution;
    private BigDecimal credit_yearly_rate;
}
