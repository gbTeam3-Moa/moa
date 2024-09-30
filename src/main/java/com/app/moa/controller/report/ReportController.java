package com.app.moa.controller.report;


import com.app.moa.domain.report.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.service.report.ReportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/report/*")
@RequiredArgsConstructor
@Slf4j

public class ReportController {
    private final ReportService reportService;
    private final ReportDTO reportDTO;

    @GetMapping("list")
    public String getList(Pagination pagination, Model model,@RequestParam(defaultValue = "recent") String view) {

        reportDTO.setMemberId(21L);
        reportDTO.setPostId(146L);
        reportDTO.setPostContent("우리집 부자다");
        pagination.setTotal(reportService.getTotal());
        pagination.progress();
        List<ReportDTO> reports = reportService.getList(pagination);

        if (reports.isEmpty()) {
            log.info("포스트 없음");
        }

        model.addAttribute("pagination", pagination);
        model.addAttribute("reports", reports);

        return "admin-page-html/admin-report/admin-report-list";
    }
//    @GetMapping("Inquiry")
//    public String () {
//
//    }
}
