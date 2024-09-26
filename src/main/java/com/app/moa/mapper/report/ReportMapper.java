package com.app.moa.mapper.report;

import com.app.moa.domain.report.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.report.ReportVO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface ReportMapper {
    //    신고하기
    public void report(ReportVO reportVO);

    //    신고된 게시글 조회(작성일 순)
    public List<ReportDTO> selectAll(Pagination pagination);

    //    신고된 게시글 조회(조회수 순)
    public List<ReportDTO> selectAllPV(Pagination pagination);

    //    전체 개수
    public int selectCount();


}