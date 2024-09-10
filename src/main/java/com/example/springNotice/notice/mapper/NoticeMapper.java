package com.example.springNotice.notice.mapper;

import com.example.springNotice.notice.dto.request.NoticeRequest;
import com.example.springNotice.notice.dto.response.NoticeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//Notice.xml 를 통해 데이터를 받아오는 인터페이스 @Mapper 에있는 @MapperSacn를 이용해서
@Mapper  // mapper 을 나타내는 어노테이션
public interface NoticeMapper {

    List<NoticeResponse> selectNoticeList();

    NoticeResponse selectOneNotice(int noticeId);

    int updateDetail(NoticeRequest request);
}