package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.task.Task;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    private String listName;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
