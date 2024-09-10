package com.example.springNotice.notice.controller;

import com.example.springNotice.notice.dto.request.NoticeRequest;
import com.example.springNotice.notice.dto.response.NoticeResponse;
import com.example.springNotice.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //해당 클래스가 컨트롤러인것을 나타내고 , 이 어노테이션이 있으면 자동으로 빈등록 @component를 가능하게함 , 요청을 해당 컨트롤러에 매핑해 처리
@RequiredArgsConstructor //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    /** 게시판 목록 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String notice(Model model) {

        List<NoticeResponse> noticeResponse = noticeService.selectNoticeList();
        System.out.println("notice noticeResponse ==> " + noticeResponse);
        model.addAttribute("notices", noticeResponse);

        return "notice/notice";
    }

    /** 게시판 상세 */
    @RequestMapping(value = "/notice-detail/{noticeId}", method = RequestMethod.GET)
    public String noticeDetail(@PathVariable("noticeId") int noticeId, Model model) {

        NoticeResponse noticeResponse = noticeService.selectOneNotice(noticeId);
        System.out.println("noticeDetail noticeResponse ==> " + noticeResponse);
        model.addAttribute("notice", noticeResponse);

        return "notice/noticeDetail";
    }

    /** 게시판 수정 */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public int updateDetail(@RequestBody NoticeRequest noticeRequest) {
        System.out.println("updateDetail noticeRequest ==> " + noticeRequest);
        return noticeService.updateDetail(noticeRequest);
    }

    /**
     * 게시판 삭제
     */
    @DeleteMapping("/delete/{noticeId}")
    @ResponseBody
    public int deleteNotice(@PathVariable("noticeId") int noticeId) {
        System.out.println("noticeId = " + noticeId);
        return noticeService.deleteNotice(noticeId);
    }


    /** 게시판 등록 화면 */
    @RequestMapping(value = "/insert-view", method = RequestMethod.GET)
    public String noticeInsertView() {
        return "notice/noticeInsert";
    }

    /** 게시판 등록 */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public int insertNotice(@RequestBody NoticeRequest noticeRequest) {
        System.out.println("insertNotice noticeRequest ==> " + noticeRequest);
        return noticeService.insertNotice(noticeRequest);
    }
}