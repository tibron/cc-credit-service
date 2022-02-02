package org.tibron.cccrediteservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class CreditInfromation {

    @Id
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;


    @Column(name = "uuid", nullable = false, updatable = false)
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID creditInstitutionUuid;

    @Column(name = "cc_name", precision=16, scale=8)
    //@Digits(integer = 10, fraction = 8)
    private String creditInstitutionName;
    @Column(name = "cc_rate", precision=16, scale=8)
    //@Digits(integer = 10, fraction = 8)
    private BigDecimal creditInstitutionYearlyRate;

    //add aditional properies
    @Column(name = "cc_min_duration")
    private Integer creditInstitutionMinimalMonthDuration;
    @Column(name = "cc_max_duration")
    private Integer creditInstitutionMaximalMonthDuration;
}
