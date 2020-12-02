package com.example.demo.service;

import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {
    @Autowired(required = false)
    MemberMapper memberMapper;
}
