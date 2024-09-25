package com.app.moa.mapper;

import com.app.moa.domain.report.ReportDTO;
import com.app.moa.mapper.report.ReportMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReportMapperTests {
    @Autowired
    private ReportMapper reportMapper;

    @Test
    public void testReport() {
        ReportDTO reportDTO = new ReportDTO();

        reportDTO.setPostId(3L); // 게시글 번호 (예: 1L)
        reportDTO.setUserId(1L); // 유저 번호 (예: 1L)
        reportDTO.setReportReason("잘못된 정보"); // 신고 사유
        reportDTO.setReportStatus(1L); // 신고사항 처리상태 (예: 1L)

        // DAO 또는 Mapper를 통해 데이터베이스에 삽입
        reportMapper.report(reportDTO.toVO());
    }


//    @Test
//    public void testUpdate() {
//        PostDTO postDTO = new PostDTO();
//        postDTO.setId(1L);
//        postDTO.setPostTitle("수정된 제목");
//        postDTO.setPostContent("수정된 내용");
//        postDTO.setPostType(3);
//        postDTO.setUserId(1L);
//        postDTO.setPostView(0);
//
//        postMapper.updateById(postDTO);
//    }
//    @Test
//    public void testSelectById() {
//        Long id = 1L;  // 테스트할 게시글 ID
//
//        PostDTO postDTO = postMapper.selectById(id);
//
//        log.info("조회된 게시글: " + postDTO);
//    }
//    @Test
//    public void testDeleteById() {
//        Long id = 4L;  // 삭제할 게시글 ID
//
//        postMapper.deleteById(id);
//
//        log.info("게시글이 삭제되었습니다. ID: " + id);
//    }


}