package com.mstar.backend_template.dashboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mstar.backend_template.auth.controller.dto.UserInfoDto;
import com.mstar.backend_template.common.ApiResponse;
import com.mstar.backend_template.dashboard.controller.dto.SearchCarHistoryDto;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("dashboard")
@Slf4j
public class DashBoardController {

    @GetMapping("searchCarHistory")
    public ResponseEntity<ApiResponse<List<SearchCarHistoryDto>>> getSearchCarHistory() {
        log.info("차량 검색 이력 조회");
        List<SearchCarHistoryDto> searchCarHistoryList = List.of(
                SearchCarHistoryDto.builder()
                        .carNumber("12가 1234")
                        .searchDate("2023-10-01")
                        .build(),
                SearchCarHistoryDto.builder()
                        .carNumber("34나 5678")
                        .searchDate("2023-10-02")
                        .build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-08 19:24").carNumber("15너6927").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-07 15:42").carNumber("15너6927").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-06 17:45").carNumber("379고2219").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-06 17:45").carNumber("22수7461").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-06 17:40").carNumber("15너6927").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-06 17:38").carNumber("15너6927").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-03 22:42").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-03 22:40").carNumber("1234").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 16:24").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 16:22").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 16:19").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 16:16").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 16:16").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 16:12").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 16:12").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 15:28").carNumber("1234").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 15:26").carNumber("181마7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-04-02 15:26").carNumber("181ak7420").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-03-31 12:45").carNumber("34조6180").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-03-17 10:59").carNumber("1234").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-03-17 10:59").carNumber("1234").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-03-17 10:59").carNumber("1234").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-03-17 10:59").carNumber("1234").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-03-17 10:59").carNumber("1234").build(),
                SearchCarHistoryDto.builder()
                        .searchDate("2023-03-17 10:59").carNumber("1234").build());
        ApiResponse<List<SearchCarHistoryDto>> response = ApiResponse
                .<List<SearchCarHistoryDto>>builder()
                .data(searchCarHistoryList)
                .message("로그인 성공")
                .build();
        return ResponseEntity.ok(response);
    }

}
