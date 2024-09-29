package com.app.moa.service.report;

import com.app.moa.domain.report.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.report.ReportVO;
import com.app.moa.domain.thesis_post.ThesisPostVO;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    public void report(ReportVO reportVO);
    public List<ReportDTO> getList(Pagination pagination);
    public int getTotal();
    public void update(ReportVO reportVO);
    public void delete(Long id);
//    public Optional<ReportDTO> getById(Long id);
}
