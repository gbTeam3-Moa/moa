package com.app.moa.controller.reply;

import com.app.moa.domain.reply.ReplyDTO;
import com.app.moa.domain.reply.ReplyVO;
import com.app.moa.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // 이 클래스가 컨트롤러임을 나타냄
@RequestMapping("/qa/*") // QA 관련 요청을 처리
@RequiredArgsConstructor // 생성자 자동 생성
@Slf4j // 로깅 기능 추가
public class ReplyController {


}
