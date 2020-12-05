package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class IndexController {
    @Autowired
    MemberService memberService;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

    // 회원 리스트 확인
    @GetMapping("/memberList")
    public ArrayList<Member> memberList(Model model){
        model.addAttribute("memberList", memberService.memberList());
        return memberService.memberList();
    }
}
