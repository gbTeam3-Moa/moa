package com.app.moa.mapper.qa_post;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.domain.qa_post.QaPostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaPostMapper {

    // 추가
    public void insert(QaPostVO qaPostVO);

    // 조회
    public QaPostDTO selectById(Long id);

    // 전체 조회
    public List<QaPostDTO> selectAll(Pagination pagination);

    // 전체 개수
    public int selectCount();

    // 수정
    void updateById(QaPostDTO qaPostDTO);

    // 삭제
    void deleteById(Long id);
}
