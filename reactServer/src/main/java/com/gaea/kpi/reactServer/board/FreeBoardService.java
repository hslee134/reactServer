package com.gaea.kpi.reactServer.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gaea.kpi.reactServer.board.db.FreeBoardEntity;
import com.gaea.kpi.reactServer.board.db.FreeBoardMapper;
import com.gaea.kpi.reactServer.board.dto.FreeBoardSaveDto;
import com.gaea.kpi.reactServer.board.util.Header;
import com.gaea.kpi.reactServer.board.util.Pagination;
import com.gaea.kpi.reactServer.board.util.Search;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FreeBoardService {
	private final FreeBoardMapper freeBoardMapper;

	Header<List<FreeBoardEntity>> getFreeBoardList(int page, int size, Search search) {
		HashMap<String, Object> paramMap = new HashMap<>();

		if (page <= 1) {	//페이지가 1 이하로 입력되면 0으로 고정,
			paramMap.put("page", 0);
		} else {			//페이지가 2 이상
			paramMap.put("page", (page - 1) * size);
		}
		paramMap.put("size", size);
		paramMap.put("sk", search.getSk());
		paramMap.put("sv", search.getSv());

		List<FreeBoardEntity> boardList = freeBoardMapper.getFreeBoardList(paramMap);
		Pagination pagination = new Pagination(
				freeBoardMapper.getFreeBoardTotalCount(paramMap),
				page,
				size,
				10
		);

		return Header.OK(boardList, pagination);
	}

	Header<FreeBoardEntity> getFreeBoardOne(Long idx) {
		return Header.OK(freeBoardMapper.getFreeBoardOne(idx));
	}

	Header<FreeBoardEntity> insertFreeBoard(FreeBoardSaveDto FreeBoardSaveDto) {
		FreeBoardEntity entity = FreeBoardSaveDto.toEntity();
		if (freeBoardMapper.insertFreeBoard(entity) > 0) {
			return Header.OK(entity);
		} else {
			return Header.ERROR("ERROR");
		}
	}

	Header<FreeBoardEntity> updateFreeBoard(FreeBoardSaveDto FreeBoardSaveDto) {
		FreeBoardEntity entity = FreeBoardSaveDto.toEntity();
		if (freeBoardMapper.updateFreeBoard(entity) > 0) {
			return Header.OK(entity);
		} else {
			return Header.ERROR("ERROR");
		}
	}

	Header<String> deleteFreeBoard(Long idx) {
		if (freeBoardMapper.deleteFreeBoard(idx) > 0) {
			return Header.OK();
		} else {
			return Header.ERROR("ERROR");
		}
	}
}
