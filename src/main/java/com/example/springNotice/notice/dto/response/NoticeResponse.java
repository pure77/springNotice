package com.example.springNotice.notice.dto.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//디비를 통해 받은 데이터를 저장하는 클래스
public class NoticeResponse {

    private  int rankNo;
    private int noticeId;
    private String title;
    private String content;
    private String createId;
    private String createAt;
    private String updateAt;

}