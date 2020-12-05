package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RestIndexController {
    @Autowired
    MemberService memberService;

    @PostMapping("/rest/join")
    public void join(Member member){
        System.out.println("restController join(): " + member.toString());

        memberService.join(member);
    }

    @PostMapping("rest/login")
    public Member login(Member member, HttpSession httpSession){
        System.out.println("restcontroller login(): " + member.toString());
        System.out.println("restController login() return : " + memberService.login(member));
        httpSession.setAttribute("user", memberService.login(member));  // 세션에 유저 등록
        return memberService.login(member);
    }

}
