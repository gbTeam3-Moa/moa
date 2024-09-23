package com.app.moa.service.qapost;

import com.app.moa.repository.qapost.QaPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QaPostServiceImpl {
    private final QaPostDAO qaPostDAO;
}
