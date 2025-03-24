package com.minjun.letswalk.service.board.query;

import com.minjun.letswalk.domain.board.dao.BoardFindDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardSearchService {

    private final BoardFindDao boardFindDao;

    public List<Long> find() {
        return boardFindDao.findAll();

    }
}
