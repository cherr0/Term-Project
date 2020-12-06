package com.example.demo.mapper;

import com.example.demo.domain.Board;
import com.example.demo.domain.Criteria;
import com.example.demo.domain.Reply;

import java.util.ArrayList;

public interface BoardMapper {
    void write(Board board); // 글작성
    ArrayList<Board> boardList(Criteria criteria); // 글리스트
    Board select(int bno); // 글열람
    void count(int bno); // 카운트 증가
    void reco(int bno); // 추천수 증가
    void delete(int bno); // 글 삭제
    void update(Board board); // 글 수정
    void reply(Reply reply); // 댓글
    ArrayList<Reply> replyList(Criteria criteria); //댓글 리스트
    void up(Reply reply); // 댓글 추천
    void down(Reply reply); // 댓글 비추
    int boardListCnt(); // 총 게시글 수
    int replyListCnt(int bno); // 총 댓글 수

}
