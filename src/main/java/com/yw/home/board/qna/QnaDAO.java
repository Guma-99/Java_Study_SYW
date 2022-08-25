package com.yw.home.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yw.home.board.impl.BoardDAO;
import com.yw.home.board.impl.BoardDTO;
import com.yw.home.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.yw.home.board.qna.QnaDAO.";

	// 글목록
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	// 상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	// 글쓰기
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "setAdd", boardDTO);
	}

	// 글 수정
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {

		return sqlSession.update(NAMESPACE + "setUpdate", boardDTO);
	}

	// 글 삭제
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {

		return sqlSession.delete(NAMESPACE + "setDelete", boardDTO);
	}

	// 댓글
	public int setReply(BoardDTO boardDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "setReply", boardDTO);
	}
	
	public int setReplyAdd(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setReplyAdd", boardDTO);
	}

	public int setStepUpdate(QnaDTO qnaDTO) throws Exception {
			
		return sqlSession.update(NAMESPACE + "setStepUpdate", qnaDTO);
			
		}

	// 글 갯수
	@Override
	public Long getCount(Pager pager) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getCount", pager);
	}

}