package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Member {
    private long mno;           // 자동 시퀀스 생성
    private String id;          // 회원 아이디
    private String password;    // 회원 패스워드
    private String name;        // 회원 이름
    private String type;        // 회원 등급
    private Date regDate;       // 회원가입 날짜
    private String email;       // 회원 이메일
}
