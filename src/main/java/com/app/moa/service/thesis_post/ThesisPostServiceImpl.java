package com.app.moa.service.thesis_post;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import com.app.moa.mapper.post.PostMapper;
import com.app.moa.mapper.thesis_post.ThesisPostMapper;
import com.app.moa.repository.post.PostDAO;
import com.app.moa.repository.thesis_post.ThesisPostDAO;
import com.app.moa.service.thesis_post.ThesisPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ThesisPostServiceImpl implements ThesisPostService {
    private final PostMapper postMapper;
    private final ThesisPostMapper thesisPostMapper;

    private final ThesisPostDAO thesisPostDAO;

    @Override
    public void write(ThesisPostDTO thesisPostDTO) {
        PostVO postVO = thesisPostDTO.toPostVO();

        // 2. PostVO 객체 삽입 (게시물 정보 저장)
        postMapper.insert(postVO);

        // 3. 삽입 후 생성된 postVO의 ID를 thesisPostDTO에 설정
        thesisPostDTO.setId(postVO.getId());

        // 4. ThesisPostVO 객체로 변환 후 논문 관련 정보 삽입
        thesisPostMapper.insert(thesisPostDTO.toVO());
    }

    @Override
    public List<ThesisPostDTO> getList(Pagination pagination) {
        return thesisPostDAO.findAll(pagination);
    }

    @Override
    public int getTotal() {
        return thesisPostDAO.findCount();
    }

    @Override
    public Optional<ThesisPostVO> getById(Long id) {
        return thesisPostDAO.findById(id);
    }

    @Override
    public void update(ThesisPostDTO thesisPostDTO) {
        // 1. PostVO 객체 생성 및 설정
        PostVO postVO = thesisPostDTO.toPostVO();

        // 2. PostVO가 제대로 생성되었는지 로그 확인
        log.info("Updating PostVO: {}", postVO);

        // 3. 게시물(PostVO) 정보 먼저 업데이트
        postMapper.updateById(postVO);

        // 4. ThesisPostVO로 변환하고 ID 값 설정
        thesisPostDTO.setId(postVO.getId());
        ThesisPostVO thesisPostVO = thesisPostDTO.toVO();

        // 5. ThesisPostVO가 제대로 생성되었는지 로그 확인
        log.info("Updating ThesisPostVO: {}", thesisPostVO);

        // 6. 논문 관련 정보 업데이트
        thesisPostMapper.update(thesisPostVO);
    }


    @Override
    public void delete(Long id) {
        thesisPostDAO.delete(id);

    }

    @Override
    public void increaseViewCount(Long id) {
        thesisPostMapper.increaseViewCountById(id);
    }
}
