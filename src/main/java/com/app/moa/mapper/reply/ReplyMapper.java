package com.app.moa.mapper.reply;

import com.app.moa.domain.reply.Pagination;
import com.app.moa.domain.reply.ReplyDTO;
import com.app.moa.domain.reply.ReplyVO;

import com.app.moa.domain.thesis_post.ThesisPostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReplyMapper {

//    댓글 추가
    public void insert(ReplyVO replyVO);

//    댓글 전체 조회(마이페이지)
    public List<ReplyDTO> selectAll(Pagination pagination);

//    해당 게시물 댓글 조회(신고된게시물, 게시글 조회)
    public Optional<ReplyVO> selectById(long id);

//    댓글 수정
    public void update(ReplyVO replyVO);

//    댓글 삭제
    public void delete(Long id);






}
