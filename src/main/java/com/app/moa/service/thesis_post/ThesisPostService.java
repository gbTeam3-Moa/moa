package com.app.moa.service.thesis_post;

import com.app.moa.domain.post.Pagination;
<<<<<<< HEAD:src/main/java/com/app/moa/service/thesispost/ThesisPostService.java
import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.domain.thesispost.ThesisPostVO;
=======
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
>>>>>>> master:src/main/java/com/app/moa/service/thesis_post/ThesisPostService.java

import java.util.List;

public interface ThesisPostService {
    public void write(ThesisPostVO thesisPostVO);
    public List<ThesisPostDTO> getList(Pagination pagination);
    public int getTotal();
}
