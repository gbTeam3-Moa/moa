package com.app.moa.service.reply;

import com.app.moa.domain.post.Pagination; // 페이징 관련 클래스
import com.app.moa.domain.reply.ReplyDTO; // 댓글 데이터 전송 객체
import com.app.moa.domain.reply.ReplyVO; // 댓글 값 객체
import com.app.moa.mapper.reply.ReplyMapper; // 댓글 매퍼 (사용되지 않음)
import com.app.moa.repository.reply.ReplyDAO; // 댓글 데이터 접근 객체
import lombok.RequiredArgsConstructor; // 생성자 주입을 위한 어노테이션
import org.springframework.stereotype.Service; // 서비스 클래스임을 나타내는 어노테이션
import org.springframework.transaction.annotation.Transactional; // 트랜잭션 관리 어노테이션

import java.util.List; // 리스트 사용
import java.util.Optional; // 옵셔널 사용

@Service // 스프링의 서비스 컴포넌트로 등록
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 주입하는 생성자 생성
@Transactional(rollbackFor = Exception.class) // 트랜잭션을 설정하고 예외 발생 시 롤백하도록 설정
public class ReplyServiceImpl implements ReplyService {
    private final ReplyDAO replyDAO; // 댓글 DAO 의존성 주입

    // 댓글 추가 메소드
    @Override
    public void write(ReplyVO replyVO) {
        // 댓글 VO를 DAO를 통해 저장
        replyDAO.save(replyVO);
    }

    // 댓글 목록 조회 메소드
    @Override
    public List<ReplyDTO> getReplies(Pagination pagination, Long postId) {
        // 주어진 게시물 ID와 페이징 정보를 통해 댓글 목록 조회
        return replyDAO.findAll(pagination, postId);
    }

    // 댓글 수정 메소드
    @Override
    public void setReply(ReplyVO replyVO) {
        // 댓글 VO를 DAO를 통해 업데이트
        replyDAO.update(replyVO);
    }

    // 댓글 삭제 메소드
    @Override
    public void delete(Long id) {
        // 주어진 ID의 댓글을 DAO를 통해 삭제
        replyDAO.delete(id);
    }

    // 특정 게시물의 총 댓글 수 조회 메소드
    @Override
    public int getTotal(Long postId) {
        // 게시물 ID를 기준으로 총 댓글 수 반환
        return replyDAO.getTotal(postId);
    }
}
