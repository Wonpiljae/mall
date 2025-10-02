package com.ex.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ex.data.BoardDTO;

@Mapper
public interface BoardMapper {
	// 최대 글번호
	public int maxNum();
	// 답글 위치
	public void reStepUp(BoardDTO dto);
	// 글 작성
	public void boardInsert(BoardDTO boardDTO);
	// 글 개수
	public int boardCount();
	// 글 목록
	public List<BoardDTO> boardList(@Param("start") int start, @Param("end") int end);
	// 조회수 +1
	public void readCountUp(int num);
	// 글 번호로 내용 조회
	public BoardDTO boardContent(int num);
	// pw 확인
	public String pwCheck(int num);
	// 글 수정
	public int boardUpdate(BoardDTO boardDTO);
	// 글 삭제
	public int boardDelete(int num);
}