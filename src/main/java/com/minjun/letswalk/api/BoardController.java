package com.minjun.letswalk.api;

import com.minjun.letswalk.api.dto.BoardQueryResponse;
import com.minjun.letswalk.api.dto.BoardAppendRequest;
import com.minjun.letswalk.global.common.ApiResponse;
import com.minjun.letswalk.service.board.BoardService;
import com.minjun.letswalk.service.board.query.BoardSearchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;
    private final BoardSearchService boardSearchService;

    @GetMapping("/v1/board/{seq}")
    public ApiResponse<List<BoardQueryResponse>> findBoard(@PathVariable Integer seq){
        List<BoardQueryResponse> boardQueryResponses = boardSearchService.findAllRecruitGenderTypeByBoard();

        return ApiResponse.ok(boardQueryResponses);
    }

    @PostMapping("/v1/board")
    public ApiResponse<Long> saveBoard(@Valid @RequestBody BoardAppendRequest boardAppendRequest){
        Long boardSaveSeq = boardService.boardSave(boardAppendRequest.toCommand());

        return ApiResponse.ok(boardSaveSeq);
    }

    @PutMapping("/v1/board/{seq}")
    public ApiResponse<?> modifyBoard(@PathVariable Integer seq){

        return ApiResponse.ok("");
    }

}
