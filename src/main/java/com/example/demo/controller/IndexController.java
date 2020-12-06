package com.example.demo.controller;

import com.example.demo.domain.Criteria;
import com.example.demo.domain.Member;
import com.example.demo.domain.Pagination;
import com.example.demo.service.BoardService;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class IndexController {
    @Autowired
    MemberService memberService;
    @Autowired
    BoardService boardService;


    // 기본 로그인 화면
    @GetMapping("/")
    public String loginForm(){
        return "loginForm";
    }

    // 회원 가입
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    // 메인 화면
    @GetMapping("/index")
    public String index(Model model, Criteria criteria, @RequestParam(defaultValue = "1") int page){
        System.out.println("index IndexController");
        Pagination pagination = new Pagination(boardService.boardListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        model.addAttribute("pagination",pagination);
        model.addAttribute("boardList",boardService.boardList(criteria));
        return "index";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

    // 글쓰기
    @GetMapping("/write")
    public String write(){
        return "write";
    }


    // 회원 리스트 확인
    @GetMapping("/memberList")
    public String memberList(Model model){
        model.addAttribute("memberList", memberService.memberList());
        return "memberList";
    }


    @GetMapping("/select/{bno}")
    public String select(Model model, @PathVariable int bno,
                         Criteria criteria, @RequestParam(defaultValue = "1") int page) {
        Pagination pagination = new Pagination(boardService.replyListCnt(bno), page, 10);
        criteria.setPage(pagination.getPage());
        criteria.setBno(bno);
        System.out.println("select bno : " + bno);
        boardService.count(bno);
        System.out.println("select() return :" + boardService.select(bno));
        model.addAttribute("pagination", pagination);
        model.addAttribute("select",boardService.select(bno));
        model.addAttribute("reply",boardService.replyList(criteria));
        return "select";
    }

    @GetMapping("/update/{bno}")
    public String update(Model model, @PathVariable int bno){
        model.addAttribute("select", boardService.select(bno));
        return "update";
    }
}
