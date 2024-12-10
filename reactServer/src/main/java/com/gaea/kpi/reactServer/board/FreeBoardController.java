package com.gaea.kpi.reactServer.board;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaea.kpi.reactServer.board.db.FreeBoardEntity;
import com.gaea.kpi.reactServer.board.dto.FreeBoardSaveDto;
import com.gaea.kpi.reactServer.board.util.Header;
import com.gaea.kpi.reactServer.board.util.Search;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FreeBoardController {
	private final FreeBoardService freeBoardService;

	//Http Get 방식으로 주소 가장 뒤 /freeBoard로 접근
	@GetMapping("/freeBoard")
	Header<List<FreeBoardEntity>> getFreeBoardList(@RequestParam(value="page", defaultValue = "0") int page, @RequestParam(value="size", defaultValue = "10") int size, Search search) {
		return freeBoardService.getFreeBoardList(page, size, search);
	}

	//idx의 데이터 1개를 조회한다.
	@GetMapping("/freeBoard/{idx}")
	Header<FreeBoardEntity> getFreeBoardOne(@PathVariable(name="idx") Long idx) {
		return freeBoardService.getFreeBoardOne(idx);
	}

	@PostMapping("/freeBoard")
	Header<FreeBoardEntity> createFreeBoard(@RequestBody FreeBoardSaveDto FreeBoardSaveDto) {
		return freeBoardService.insertFreeBoard(FreeBoardSaveDto);
	}

	@PatchMapping("/freeBoard")
	Header<FreeBoardEntity> updateFreeBoard(@RequestBody FreeBoardSaveDto FreeBoardSaveDto) {
		return freeBoardService.updateFreeBoard(FreeBoardSaveDto);
	}

	@DeleteMapping("/freeBoard/{idx}")
	Header<String> deleteFreeBoard(@PathVariable(name="idx") Long idx) {
		return freeBoardService.deleteFreeBoard(idx);
	}
}
