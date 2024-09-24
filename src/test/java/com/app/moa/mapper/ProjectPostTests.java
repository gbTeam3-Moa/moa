package com.app.moa.mapper;

import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.mapper.projectpost.ProjectPostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectPostTests {

    @Autowired
    private ProjectPostMapper projectPostMapper;

    @Test
    public void testInsert() {
        ProjectPostDTO projectPostDTO = new ProjectPostDTO();
        projectPostDTO.setProjectField("Software Development");
        projectPostDTO.setProjectRequirement("Need Java Developer");

        projectPostMapper.insert(projectPostDTO.toVO());

        log.info("프로젝트 포스트가 삽입됨! " + projectPostDTO);
    }

    @Test
    public void testSelectById() {
        Long id = 1L;  // 조회할 프로젝트 포스트 ID
        ProjectPostDTO projectPostDTO = projectPostMapper.selectById(id);

        log.info("조회된 프로젝트 포스트: " + projectPostDTO);
    }

    @Test
    public void testUpdate() {
        ProjectPostDTO projectPostDTO = new ProjectPostDTO();
        projectPostDTO.setId(1L);  // 수정할 포스트의 ID
        projectPostDTO.setProjectField("Updated Field");
        projectPostDTO.setProjectRequirement("Updated Requirement");

        projectPostMapper.updateById(projectPostDTO);

        log.info("프로젝트 포스트가 수정됨! " + projectPostDTO);
    }


    @Test
    public void testDeleteById() {
        Long id = 1L;  // 삭제할 포스트의 ID
        projectPostMapper.deleteById(id);

        log.info("프로젝트 포스트가 삭제됨! ID: " + id);
    }
}
