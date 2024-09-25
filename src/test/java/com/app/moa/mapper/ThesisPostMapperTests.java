package com.app.moa.mapper;

import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.mapper.thesispost.ThesisPostMapper;
import com.app.moa.service.thesispost.ThesisPostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class ThesisPostMapperTests {

    @Autowired
    private  ThesisPostMapper thesisPostMapper;



}