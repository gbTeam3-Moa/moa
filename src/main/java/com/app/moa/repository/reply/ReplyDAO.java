package com.app.moa.repository.reply;



import com.app.moa.domain.reply.Pagination;
import com.app.moa.domain.reply.ReplyDTO;
import com.app.moa.domain.reply.ReplyVO;
import com.app.moa.mapper.reply.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;
    private final ReplyVO replyVO;

    //    댓글 추가
    public void save(ReplyVO replyVO) {replyMapper.insert(replyVO);}

////    댓글 전체 조회(마이페이지)
//    public List<ReplyDTO> findAll(Pagination pagination) {
//        return replyMapper.selectAll(pagination);
//    }

    //    댓글 전체 조회(게시글 댓글)
    public List<ReplyDTO> findAllByPostId(long postId) {
        return replyMapper.selectAllByPostId(postId);
    }


    //    해당 게시물 댓글 조회(신고된게시물
    public Optional<ReplyVO> findById(long id) {return replyMapper.selectById(id);}

    //    댓글 수정
    public void update(ReplyVO replyVO) {
        replyMapper.update(replyVO);
    }

    //    댓글 삭제
    public void delete(Long id) {replyMapper.delete(id);}

}