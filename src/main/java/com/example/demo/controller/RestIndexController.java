package com.example.demo.controller;

import com.example.demo.domain.Email;
import com.example.demo.domain.Member;
import com.example.demo.service.EmailService;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RestIndexController {
    @Autowired
    MemberService memberService;
    @Autowired
    EmailService emailService;


    // 회원가입
    @PostMapping("/rest/join")
    public void join(Member member){
        System.out.println("restController join(): " + member.toString());

        memberService.join(member);
    }

    // 로그인
    @PostMapping("rest/login")
    public Member login(Member member, HttpSession httpSession){
        System.out.println("restController login(): " + member.toString());
        System.out.println("restController login() return : " + memberService.login(member));
        httpSession.setAttribute("user", memberService.login(member));  // 세션에 유저 등록
        return memberService.login(member);
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



}
