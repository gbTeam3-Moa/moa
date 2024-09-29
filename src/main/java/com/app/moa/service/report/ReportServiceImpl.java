package com.app.moa.service.report;

import com.app.moa.domain.report.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.report.ReportVO;
import com.app.moa.mapper.report.ReportMapper;
import com.app.moa.repository.report.ReportDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportDAO reportDAO;
    private final ReportMapper reportMapper;
//    private final ReportDTO reportDTO;

    @Override
    public void report(ReportVO reportVO) {
        reportDAO.save(reportVO);
    }

//  신고된 게시물 목록 조회
    @Override
    public List<ReportDTO> getList(Pagination pagination) {
        return reportDAO.findAll(pagination);
    }

    @Override
    public int getTotal() {
        return reportDAO.findCount();
    }

    @Override
    public void update (ReportVO reportVO) {reportMapper.update(reportVO);}

////    신고된 게시물 조회
//    @Override
//    public Optional<ReportVO> getById(Long id) {
//        return reportDAO.findById(id);
//    }
}
















