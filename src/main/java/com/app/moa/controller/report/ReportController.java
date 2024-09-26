package com.app.moa.controller.report;


import com.app.moa.domain.report.Pagination;
import com.app.moa.service.report.ReportService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin-page-html/admin-report/*")
@RequiredArgsConstructor

public class ReportController {
    private final ReportService reportService;

    @GetMapping("admin-report-list")
    public void getList(Pagination pagination, Model model) {
        pagination.setTotal(reportService.getTotal());
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("reports", reportService.getList(pagination));
    }
}
