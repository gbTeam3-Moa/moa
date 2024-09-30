package com.app.moa.service.qa_post;

import com.app.moa.domain.post.Pagination; // 페이징 처리 클래스
import com.app.moa.domain.post.PostVO; // 게시글 VO
import com.app.moa.domain.qa_post.QaPostDTO; // Q&A 게시글 DTO
import com.app.moa.domain.qa_post.QaPostVO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import com.app.moa.mapper.post.PostMapper;
import com.app.moa.mapper.qa_post.QaPostMapper;
import com.app.moa.mapper.thesis_post.ThesisPostMapper;
import com.app.moa.repository.post.PostDAO; // 게시글 데이터 접근 객체
import com.app.moa.repository.qa_post.QaPostDAO; // Q&A 게시글 데이터 접근 객체
import lombok.RequiredArgsConstructor; // 생성자 자동 생성
import org.springframework.context.annotation.Primary; // 우선 순위 지정
import org.springframework.stereotype.Service; // 서비스 컴포넌트
import org.springframework.transaction.annotation.Transactional; // 트랜잭션 관리

import java.util.List; // 리스트 사용
import java.util.Optional;

@Service // 이 클래스가 서비스임을 나타냄
@Primary // 우선 순위가 높은 서비스
@RequiredArgsConstructor // 생성자 자동 생성
@Transactional(rollbackFor = Exception.class) // 예외 발생 시 롤백 처리
public class QaPostServiceImpl implements QaPostService {
    private final PostMapper postMapper;
    private final QaPostMapper qaPostMapper;
    private final QaPostDAO qaPostDAO; // Q&A 게시글 DAO
    private final PostDAO postDAO; // 게시글 DAO

    @Override
    public void write(QaPostDTO qaPostDTO) {
        PostVO postVO = qaPostDTO.toPostVO();

        // 2. PostVO 객체 삽입 (게시물 정보 저장)
        postMapper.insert(postVO);

        // 3. 삽입 후 생성된 postVO의 ID를 qaPostDTO에 설정
        qaPostDTO.setId(postVO.getId());

        // 4. qaostVO 객체로 변환 후 논문 관련 정보 삽입
        qaPostMapper.insert(qaPostDTO.toVO());
    }

    @Override
    public Optional<QaPostVO> getById(Long id) {
        return qaPostDAO.findById(id);
    }

    @Override
    public List<QaPostDTO> getList(Pagination pagination) {
        return qaPostDAO.findAll(pagination); // 페이징된 Q&A 게시글 목록 조회
    }

    @Override
    public int getTotal() {
        return qaPostDAO.findCount(); // 총 Q&A 게시글 수 조회
    }

    @Override
    public void update(QaPostDTO qaPostDTO) {
        qaPostDAO.update(qaPostDTO); // Q&A 게시글 수정
    }

    @Override
    public void delete(Long id) {
        qaPostDAO.delete(id); // ID로 Q&A 게시글 삭제
    }
}
