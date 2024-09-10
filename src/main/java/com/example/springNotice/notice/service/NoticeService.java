package com.example.springNotice.notice.service;

import com.example.springNotice.notice.dto.request.NoticeRequest;
import com.example.springNotice.notice.dto.response.NoticeResponse;
import com.example.springNotice.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //비즈니스 로직 에 대한 정보, 사용자의 요청에 따라서 DB에 접근하여 데이터를 추가, 삭제, 수정, 선택과 같은 요청을 처리할 수 있어야 합니다 , 컴포너트스캔 자동 빈등록
@RequiredArgsConstructor //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
public class NoticeService {

    private final NoticeMapper noticeMapper; // noticeMapper 생성자 생성 


    public List<NoticeResponse> selectNoticeList() {
        return noticeMapper.selectNoticeList() ; /*noticeMapper.selectNoticeList();*/ //noticeMapper 를 통해 받아온 디비 데이터를 NoticeResponse 타입으로 리턴 -> 리스트 타입으로 변경
    }
    public NoticeResponse selectOneNotice(int noticeId) // 단건 조회
    {
        return  noticeMapper.selectOneNotice(noticeId);
    }

    public int updateDetail(NoticeRequest request) {
        return noticeMapper.updateDetail(request);
    }
}