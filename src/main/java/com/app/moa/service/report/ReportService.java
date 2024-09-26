package com.app.moa.service.report;

import com.app.moa.domain.report.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.report.ReportVO;

import java.util.List;

public interface ReportService {
    public void report(ReportVO reportVO);
    public List<ReportDTO> getList(Pagination pagination);
    public int getTotal();
}