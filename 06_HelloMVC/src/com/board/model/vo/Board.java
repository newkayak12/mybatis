package com.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Board {
	String boardNo, boardTitle, boardWriter, boardContent;
	String boardOriginalFileName, boardRenameFileName;
	String boardDate;
	int boardReadCount;
	

}
