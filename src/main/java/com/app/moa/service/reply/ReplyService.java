package com.app.moa.service.reply;

import com.app.moa.domain.reply.Pagination;
import com.app.moa.domain.reply.ReplyDTO;
import com.app.moa.domain.reply.ReplyVO;

import java.util.List;
import java.util.Optional;

public interface ReplyService {

    public void write(ReplyDTO replyDTO);
//    public List<ReplyDTO> getList(Pagination pagination);
//    public Optional<ReplyVO> getById(Long id);
//    public void update(ReplyVO replyVOVO);
//    public void delete(Long id);
}
