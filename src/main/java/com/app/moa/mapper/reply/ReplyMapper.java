package com.app.moa.mapper.reply;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.reply.ReplyDTO;
import com.app.moa.domain.reply.ReplyVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReplyMapper {
    //    댓글 추가
    public void insert(ReplyVO replyVO);

    //    댓글 목록
    public List<ReplyDTO> selectAll(@Param("pagination") Pagination pagination, @Param("postId") Long postId);

    //    댓글 수정
    public void update(ReplyVO replyVO);

    //    댓글 삭제
    public void delete(Long id);

    //    댓글 전체 개수
    public int selectCount(Long postId);

}
