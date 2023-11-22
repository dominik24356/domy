package com.example.domy.user;

import com.example.domy.board.Board;
import com.example.domy.tasklist.TaskList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String login;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Board> boards;
}
