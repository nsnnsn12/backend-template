package com.mstar.backend_template.dashboard.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchCarHistoryDto {
    private String carNumber;
    private String searchDate;
}
