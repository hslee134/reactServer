package com.gaea.kpi.reactServer.board.db;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FreeBoardMapper {
	List<FreeBoardEntity> getFreeBoardList(HashMap<String, Object> paramMap);

	int getFreeBoardTotalCount(HashMap<String, Object> paramMap);

	FreeBoardEntity getFreeBoardOne(Long idx);

	int insertFreeBoard(FreeBoardEntity entity);

	int updateFreeBoard(FreeBoardEntity entity);

	int deleteFreeBoard(Long idx);
}
