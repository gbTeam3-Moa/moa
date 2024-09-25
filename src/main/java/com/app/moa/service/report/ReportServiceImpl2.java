//package com.app.moa.service.report;
//
//import com.app.moa.domain.report.ReportDTO;
//import com.app.moa.repository.report.ReportDAO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ReportServiceImpl2 implements ReportService {
//
//    private final ReportDAO reportDAO;
//    private final ReportDTO reportDTO;
//
//
//    @Override
//    public void report(ReportVO reportVO) {
////        ReportVO reportVO = reportDTO.toVO();
//                reportDAO.save(reportVO);
//    }
//
//    @Override
//    public List<ReportDTO> getList(Pagination pagination) {
//        return reportDAO.findAll(pagination);
//        }
//
//}