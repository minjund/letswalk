package com.minjun.letswalk.api;

import com.minjun.letswalk.service.board.query.BoardSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardSearchService boardSearchService;

    @GetMapping("/v1/board")
    public ResponseEntity<?> findBoard(){

        boardSearchService.find();
        return ResponseEntity.ok("");
    }
}
