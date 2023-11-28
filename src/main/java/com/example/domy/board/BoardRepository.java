package com.example.domy.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> getByBoardId(Long boardId);

    List<Board> getBoardsByUser_UserId(Long userId);


}
