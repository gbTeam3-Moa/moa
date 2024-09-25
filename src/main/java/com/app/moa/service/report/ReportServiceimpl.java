package com.app.moa.service.report;

import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.report.ReportVO;
import com.app.moa.repository.report.ReportDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReportServiceimpl implements ReportService {
    
    private final ReportDAO reportDAO;
    private final ReportDTO reportDTO;


    @Override
    public void report(ReportVO reportVO) {
//        ReportVO reportVO = reportDTO.toVO();
        reportDAO.save(reportVO);
    }


}
