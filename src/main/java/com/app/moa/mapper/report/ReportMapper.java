package com.app.moa.mapper.report;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.report.ReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    //    신고하기
    public void report(ReportVO reportVO);

    //    신고된 게시글 조회
    public List<ReportDTO> selectAll(@Param("pagination") Pagination pagination, @Param("order") String order);

}