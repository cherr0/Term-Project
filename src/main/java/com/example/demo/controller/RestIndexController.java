package com.example.demo.controller;

import com.example.demo.domain.Email;
import com.example.demo.domain.Member;
import com.example.demo.service.EmailService;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class RestIndexController {
    @Autowired
    MemberService memberService;
    @Autowired
    EmailService emailService;


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
        if(memberService.login(member)){
            httpSession.setAttribute("user", member);
            verify = 1;
        }
        System.out.println(verify);
        return verify;


    }

    //로그아웃 처리
    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session) {

        memberService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("msg", "logout");

        return mav;
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
