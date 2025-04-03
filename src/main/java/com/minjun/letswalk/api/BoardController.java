package com.minjun.letswalk.api;

import com.minjun.letswalk.api.dto.BoardQueryResponse;
import com.minjun.letswalk.api.dto.BoardAppendRequest;
import com.minjun.letswalk.service.board.BoardService;
import com.minjun.letswalk.service.board.query.BoardSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;
    private final BoardSearchService boardSearchService;

    @GetMapping("/v1/board/{seq}")
    public ResponseEntity<List<BoardQueryResponse>> findBoard(@PathVariable Integer seq){
        List<BoardQueryResponse> boardQueryResponses = boardSearchService.findAllRecruitGenderTypeByBoard();

        return ResponseEntity.ok(boardQueryResponses);
    }

    @PostMapping("/v1/board")
    public ResponseEntity<Long> saveBoard(@RequestBody BoardAppendRequest boardAppendRequest){
        Long boardSaveSeq = boardService.save(boardAppendRequest.toCommand());

        return ResponseEntity.ok(boardSaveSeq);
    }

    @PutMapping("/v1/board/{seq}")
    public ResponseEntity<?> modifyBoard(@PathVariable Integer seq){

        return ResponseEntity.ok("");
    }

}
