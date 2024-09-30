package com.app.moa.mapper.qa_post;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.domain.qa_post.QaPostVO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QaPostMapper {
    // 추가
    public void insert(QaPostVO qaPostVO);
    // 조회
    public Optional<QaPostVO> selectById(Long id);
    // 전체 조회
    public List<QaPostDTO> selectAll(Pagination pagination);
    // 전체 개수
    public int selectCount();
    // 수정
    public void update(QaPostDTO qaPostDTO);
    // 삭제
    void deleteById(Long id);
}
