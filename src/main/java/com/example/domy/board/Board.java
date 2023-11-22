package com.example.domy.board;

import com.example.domy.tasklist.TaskList;
import com.example.domy.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String boardName;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<TaskList> taskLists;

}
