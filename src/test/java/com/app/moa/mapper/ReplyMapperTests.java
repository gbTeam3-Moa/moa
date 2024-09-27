package com.app.moa.mapper;

import com.app.moa.domain.reply.Pagination;
import com.app.moa.domain.reply.ReplyDTO;
import com.app.moa.domain.reply.ReplyVO;
import com.app.moa.mapper.reply.ReplyMapper;
import com.app.moa.repository.reply.ReplyDAO;
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
    private ReplyDAO replyDAO;
    @Autowired
    private ReplyVO replyVO;


    @Test
    public void testInsert() {
        ReplyDTO replyDTO = new ReplyDTO();

        replyDTO.setPostId(1L); // 게시글 번호 (예: 1L)
        replyDTO.setMemberId(21L); // 멤버 번호 (예: 1L)
        replyDTO.setReplyContent("당신 게시물 신고합니다2"); // 댓글 내용
        replyDTO.setGroupId(1L);
        replyDTO.setReplyDepth(0);
        log.info(replyDTO.toString());
        // DAO 또는 Mapper를 통해 데이터베이스에 삽입
        replyMapper.insert(replyDTO.toVO());
    }

//    @Test
//    public void testInsert(){
//    ReplyDTO replyDTO = new ReplyDTO();
//        replyDTO.setReplyContent("대댓글 테스트1");
//        replyDTO.setReplyGroupId(5L);
//        replyDTO.setMemberId(3L);
//        replyDTO.setPostId(1L);

//======================================================================

    @Test
    public void testSelectAllByPostId() {
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setMemberId(21L);
        replyDTO.setPostId(1L);
        replyDTO.setGroupId(1L);
        List<ReplyDTO> replys = replyMapper.selectAllByPostId(replyVO.getPostId());
        replys.stream().map(ReplyDTO::toString).forEach(log::info);
    }

    @Test
    public void testUpdate(){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setId(1L);
        replyDTO.setReplyContent("수정된 댓글12");
        replyMapper.update(replyDTO.toVO());
    }

    @Test
    public void testDelete(){
        Long id = 1L;
        log.info(replyMapper.toString());
        replyMapper.delete(id);
    }


}