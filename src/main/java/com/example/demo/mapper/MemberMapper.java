package com.example.demo.mapper;

import com.example.demo.domain.Member;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public interface MemberMapper {
    void join(Member member);   // 회원가입

    int loginChk(Member member);    // 로그인 확인

    Member login(Member member);    // 로그인

    void logout(HttpSession session);   // 로그아웃

    ArrayList<Member> memberList(); // 회원리스트
}
