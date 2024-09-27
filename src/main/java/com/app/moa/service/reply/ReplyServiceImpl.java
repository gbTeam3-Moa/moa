package com.app.moa.service.reply;


import com.app.moa.domain.reply.Pagination;
import com.app.moa.domain.reply.ReplyDTO;
import com.app.moa.domain.reply.ReplyVO;
import com.app.moa.mapper.reply.ReplyMapper;
import com.app.moa.repository.reply.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)

public class ReplyServiceImpl implements ReplyService {
    private final ReplyMapper replyMapper;
    private final ReplyDAO replyDAO;
    private final ReplyVO replyVO;



    //    댓글 작성
    @Override
    public void write(ReplyDTO replyDTO) {
        replyMapper.insert(replyVO);
    }

//    댓글 전체 조회
    @Override
    public List<ReplyDTO> getList(Pagination pagination) {
        return replyDAO.findAll(pagination);
    }
//
////    댓글 조회
//@Override
//public Optional<ReplyVO> getById(Long id) {
//    return replyDAO.findById(id);
//}

//    댓글 수정
    @Override
    public void update(ReplyVO replyVO) {
        replyMapper.update(replyVO);
    }
//  댓글 삭제
    @Override
    public void delete(Long id) {
        replyMapper.delete(id);

    }

}
