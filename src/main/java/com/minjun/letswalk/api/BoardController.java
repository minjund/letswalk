package com.minjun.letswalk.api;

import com.minjun.letswalk.api.dto.BoardRequest;
import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.service.board.BoardSaveCommend;
import com.minjun.letswalk.service.board.BoardSaveResult;
import com.minjun.letswalk.service.board.BoardService;
import com.minjun.letswalk.service.board.query.BoardSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardSearchService boardSearchService;
    private final BoardService boardService;

    @GetMapping("/v1/board")
    public ResponseEntity<List<BoardEntity>> findBoard(){
        List<BoardEntity> boardEntities = boardSearchService.find();

        return ResponseEntity.ok(boardEntities);
    }

    @PostMapping("/v1/board")
    public ResponseEntity<?> saveBoard(@RequestBody BoardRequest boardRequest){
        BoardSaveCommend boardSaveCommend = BoardSaveCommend.of(boardRequest);

        BoardSaveResult boardSeq = boardService.save(boardSaveCommend);

        return ResponseEntity.ok(boardSeq);
    }

}
