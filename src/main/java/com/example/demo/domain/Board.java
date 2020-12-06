package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Board {
    private int bno;        // 시퀀스 번호
    private int board_idx;  // 게시판별 고유 번호
    private String title;   // 글 이름
    private String content; // 내용
    private String writer;  // 작성자
    private Date regDate;   // 작성일
    private int mno;       // 작성자 번호
    private int count;      // 조회수
    private int reco;       // 추천수
}

