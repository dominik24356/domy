package com.example.domy.board;

import com.example.domy.tasklist.TaskList;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String boardName;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<TaskList> taskLists;

}
