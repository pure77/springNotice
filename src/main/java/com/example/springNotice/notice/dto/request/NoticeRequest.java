package com.example.springNotice.notice.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NoticeRequest {

    private int noticeId;
    private String title;
    private String content;
    private String createId;
    private String createAt;
    private String updateAt;

}