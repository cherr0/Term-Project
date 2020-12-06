package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.domain.Criteria;
import com.example.demo.domain.Reply;
import com.example.demo.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired(required = false)
    BoardMapper boardMapper;

    // 글작성
    public void write(Board board){
        boardMapper.write(board);
    }

    // 글리스트
    public ArrayList<Board> boardList(Criteria criteria) {
        return boardMapper.boardList(criteria);
    }

    // 글열람
    public Board select(int bno){
        System.out.println("service select(): " + boardMapper.select(bno));
        return boardMapper.select(bno);
    }

    // 조회수
    public void count(int bno){
        boardMapper.count(bno);
    }

    public void reco(int bno){
        boardMapper.reco(bno);
    }

    public void delete(int bno){
        System.out.println("service delete(): " + bno);
        boardMapper.delete(bno);
    }

    // 글 수정
    public void update(Board board){
        boardMapper.update(board);
    }

    public void reply(Reply reply){
        boardMapper.reply(reply);
    }

    // 댓글 리스트
    public ArrayList<Reply> replyList(Criteria criteria){
        return boardMapper.replyList(criteria);
    }


    // 댓글 추천
    public void up(Reply reply){
        boardMapper.up(reply);
    }

    // 댓글 비추
    public void down(Reply reply){
        boardMapper.down(reply);
    }

    // 총 게시글 수
    public int boardListCnt(){
        return boardMapper.boardListCnt();
    }

    //총 댓글 수
    public int replyListCnt(int bno){
        return boardMapper.replyListCnt(bno);
    }
}
