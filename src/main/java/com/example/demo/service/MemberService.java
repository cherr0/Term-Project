package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired(required = false)
    MemberMapper memberMapper;

    @Autowired
    SqlSession sqlSession;

    // 회원가입
    public void join(Member member){
        System.out.println("service join(): " + member.toString());
        memberMapper.join(member);
    }

    // 로그인
    public Boolean login(Member member){
        int name = memberMapper.login(member);
        System.out.println(name);
        System.out.println("service login() :" + member.toString());

        // 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
        return name != 0;
    }

    // 로그아웃
    public void logout(HttpSession session){
        System.out.println("service logout() Session : " + session);
        session.invalidate();
    }

    // 회원리스트
    public ArrayList<Member> memberList() {
        System.out.println("service memberList(): " + memberMapper.memberList());
        return memberMapper.memberList();
    }
}
