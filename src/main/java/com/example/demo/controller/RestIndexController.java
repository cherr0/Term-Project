package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.Email;
import com.example.demo.domain.Member;
import com.example.demo.domain.Reply;
import com.example.demo.service.BoardService;
import com.example.demo.service.EmailService;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class RestIndexController {
    @Autowired
    MemberService memberService;
    @Autowired
    EmailService emailService;
    @Autowired
    BoardService boardService;


    // 회원가입
    @PostMapping("/rest/join")
    public void join(Member member, HttpSession httpSession){
        System.out.println("restController join(): " + member.toString());

        httpSession.setAttribute("user", member);
        memberService.join(member);
    }

    //로그인 처리
    @PostMapping("/rest/login")
    public int loginCheck(Member member, HttpSession httpSession) {
        System.out.println("loginCheck()");
        var verify = 0;
        if(memberService.loginChk(member)){
            httpSession.setAttribute("user", memberService.login(member));
            verify = 1;
        }
        System.out.println(verify);
        return verify;


    }

    // 메일 전송
    @PostMapping("rest/email")
    public void sendMail(Email email) throws Exception {
        emailService.sendSimpleMessage(email.getUserEmail());
        System.out.println("메일 전송 완료");
    }

    // 인증 코드
    @PostMapping("rest/confirm")
    public int confirm(Email email) {
        if(emailService.ePw.equals(email.getConfirm())){
            System.out.println("적은 인증번호() : " + email.getConfirm());
            return EmailService.CONFIRM;
        }else {
            System.out.println("적은 인증번호() : " + email.getConfirm());
            return EmailService.REJECT;
        }
    }

    // 글작성
    @PostMapping("/rest/write")
    public void write(Board board){
        System.out.println("restController write(): " + board.toString());
        boardService.write(board);
    }

    @PutMapping("/rest/reco")
    public void reco(int bno){
        System.out.println("restController reco(): " + bno);
        boardService.reco(bno);
    }

    // 글 삭제
    @DeleteMapping("/rest/delete")
    public void delete(int bno){
        System.out.println("restContorller delete(): " + bno);
        boardService.delete(bno);
    }

    // 글 수정
    @PutMapping("/rest/update")
    public void update(Board board){
        boardService.update(board);
    }

    @PostMapping("/rest/reply")
    public void reply(Reply reply){
        boardService.reply(reply);
    }

    // 댓글 추천
    @PutMapping("/rest/up")
    public void up(Reply reply){
        boardService.up(reply);
    }

    // 댓글 비추
    @PutMapping("/rest/down")
    public void down(Reply reply){
        boardService.down(reply);
    }


}
