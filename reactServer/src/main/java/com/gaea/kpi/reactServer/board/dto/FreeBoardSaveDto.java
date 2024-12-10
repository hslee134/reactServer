package com.gaea.kpi.reactServer.board.dto;

import com.gaea.kpi.reactServer.board.db.FreeBoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreeBoardSaveDto {
	private Long idx;
	private String title;
	private String contents;
	private String regUser;

	public FreeBoardEntity toEntity() {
		return FreeBoardEntity.builder()
				.idx(idx)
				.title(title)
				.contents(contents)
				.regUser(regUser)
				.build();
	}
}
