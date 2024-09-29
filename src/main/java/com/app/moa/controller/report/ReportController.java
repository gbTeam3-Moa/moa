package com.app.moa.controller.report;


import com.app.moa.domain.report.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.service.report.ReportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/report/*")
@RequiredArgsConstructor
@Slf4j

public class ReportController {
    private final ReportService reportService;

    @GetMapping("list")
    public String getList(Pagination pagination, Model model) {
        pagination.setTotal(reportService.getTotal());
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("reports", reportService.getList(pagination));
        List<ReportDTO> reports = reportService.getList(pagination);

        if (reports.isEmpty()) {
            log.info("포스트 없음");
        }

        model.addAttribute("pagination", pagination);
        model.addAttribute("reports", reports);

        return "admin-page-html/admin-report/admin-report-list";
    }
}
