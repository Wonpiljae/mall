package com.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.data.BoardDTO;
import com.ex.repository.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper boardMapper;
	
	// 글 작성
	public void insert(BoardDTO dto) {
		int maxNum = boardMapper.maxNum();
		if( dto.getNum() != 0 ) {	// 글번호 있다 => 답글인 경우
			boardMapper.reStepUp(dto);
			dto.setRef(dto.getNum());
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_level(dto.getRe_level()+1);
		}else {	// 새 글인 경우
			dto.setRef(maxNum+1);
		}
		boardMapper.boardInsert(dto);
	}
	
	// 글 개수
	public int count() {
		return boardMapper.boardCount();
	}
	// 글 목록
	public List<BoardDTO> list(int start, int end){
		return boardMapper.boardList(start, end);
	}
	
	// 글 내용 (조회수 +1)	
	public BoardDTO content(int num) {
		boardMapper.readCountUp(num);
		return boardMapper.boardContent(num);
	}

	// pw 확인 : 입력 pw와 DB pw 비교
	public boolean pwCheck(int num, String pw) {
		boolean result = false;
		String dbPw = boardMapper.pwCheck(num);
		if(dbPw.equals(pw)) {
			result = true;
		}
		return result;
	}
	
	// pw 확인(pwCheck.html) 후 -> updateForm.html
	// updateForm 글 내용(글 수정 페이지)	: content 메서드에 조회수 올리기 있음 재사용 X
	public BoardDTO upContent(int num) {
		return boardMapper.boardContent(num);
	}
	
	// updatePro DB에 데이터 수정
	public int update(BoardDTO boardDTO) {
		return boardMapper.boardUpdate(boardDTO);
	}
	
	// pw 확인(pwCheck.html) 후 -> deletePro.html
	// 글 삭제
	public int delete(int num) {
		return boardMapper.boardDelete(num);
	}
}