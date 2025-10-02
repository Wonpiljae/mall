package com.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.data.MemberDTO;
import com.ex.repository.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service	// 비즈니스 로직 처리, Mapper - Controller
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	// 회원가입
	public int insert( MemberDTO memberDTO ) {
		// 메서드 호출을 return 보냄
		return memberMapper.memberInsert(memberDTO);
	}
	
	// 로그인
	public int login(String username, String password) {
		int result = memberMapper.loginCheck(username, password);
		// 변수에 담아서 return 시킴.
		return result;
	}
	
	// 내정보
	public MemberDTO myInfo(String username) {
		return memberMapper.myInfo(username);
	}
	
	// 전체 회원 정보
	public List<MemberDTO> allInfo(){
		return memberMapper.memberAll();
	}
	// 회원 탈퇴
	public void delete(String username) {
		memberMapper.memberDelete(username);
	}
	
	public void update(MemberDTO memberDTO) {
		memberMapper.memberUpdate(memberDTO);
	}
}