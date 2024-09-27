package com.app.moa.mapper;

import com.app.moa.domain.reply.Pagination;
import com.app.moa.domain.reply.ReplyDTO;

import com.app.moa.mapper.reply.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;


    @Test
    public void testInsert() {
        ReplyDTO replyDTO = new ReplyDTO();

        replyDTO.setPostId(1L); // 게시글 번호 (예: 1L)
        replyDTO.setMemberId(21L); // 멤버 번호 (예: 1L)
        replyDTO.setReplyContent("당신 게시물 신고합니다"); // 댓글 내용
        replyDTO.setCreatedDate("2024-12-31"); // 댓글 작성 시간

        // DAO 또는 Mapper를 통해 데이터베이스에 삽입
        replyMapper.insert(replyDTO.toVO());
    }

//    @Test
//    public void testSelectAll() {      //목록 순서
//        Pagination pagination = new Pagination();
//        pagination.setPage(1);
//        pagination.setTotal(reportMapper.selectCount());
//        pagination.progress();
//        List<ReportDTO> reports = reportMapper.selectAll(pagination);
//        log.info("{}", reports.size());
////        log.info("{}", reportMapper);
////        log.info("{}", reportDTO);
//        reports.stream().map(ReportDTO::toString).forEach(log::info);
//    }



    //    @Test
//    public void testSelectAll() {
//        ReportDTO reportDTO = new ReportDTO();
//
//        reportDTO.setId(1L);
//        reportDTO.setPostId(3L);
//        reportDTO.setUserId(1L);
//        reportDTO.setReportReason("잘못된 정보");
//        reportDTO.setReportStatus(1L);
//    }

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