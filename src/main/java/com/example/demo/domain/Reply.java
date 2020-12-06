package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    private int rno;
    private String rcontent;
    private String rwriter;
    private Date regDate;
    private int up;
    private int down;
    private int bno;
    private int mno;
}
