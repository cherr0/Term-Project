package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired(required = false)
    MemberMapper memberMapper;

    // 회원가입
    public void join(Member member){
        System.out.println("service join(): " + member.toString());
        memberMapper.join(member);
    }

    // 로그인
    public Member login(Member member){
        System.out.println("service login() :" + member.toString());
        System.out.println("service login() : " + memberMapper.login(member));
        return memberMapper.login(member);
    }

    // 회원리스트
    public ArrayList<Member> memberList() {
        System.out.println("service memberList(): " + memberMapper.memberList());
        return memberMapper.memberList();
    }
}
