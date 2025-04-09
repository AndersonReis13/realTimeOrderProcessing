package com.as._3.realtimeorderprocessing.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DateRangeRequest(@JsonFormat(pattern = "dd/MM/yyyy")
                               LocalDate startDate,
                               @JsonFormat(pattern = "dd/MM/yyyy")
                               LocalDate endDate
                               ) {
}
