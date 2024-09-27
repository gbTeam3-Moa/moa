package com.app.moa.mapper.report;

import com.app.moa.domain.report.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.report.ReportVO;
import com.app.moa.repository.report.ReportDAO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Optional;

@Mapper
public interface ReportMapper {



    //    신고하기
    public void report(ReportVO reportVO);

    //    신고된 게시글 조회
    public List<ReportDTO> selectAll(Pagination pagination);

    //    신고된 게시글 ID로 조회
    public Optional<ReportVO> selectById(Long id);

    //    전체 개수
    public int selectCount();


}