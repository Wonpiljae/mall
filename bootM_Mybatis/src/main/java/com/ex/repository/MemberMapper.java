package com.ex.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ex.data.MemberDTO;


@Mapper	
public interface MemberMapper {			
	// 회원 가입
	public int memberInsert(MemberDTO memberDTO);
	// 로그인확인
	public int loginCheck(@Param("username") String username, @Param("password") String password);
	// 해당 username 에 대한 모든 정보
	public MemberDTO myInfo(String username);
	// 전체 회원 정보
	public List<MemberDTO> memberAll();
	// 회원 탈퇴
	public void memberDelete(String username);
	// 정보 수정
	public void memberUpdate(MemberDTO memberDTO);
}