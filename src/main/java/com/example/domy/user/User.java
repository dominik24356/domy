package com.example.domy.user;

import com.example.domy.board.Board;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String login;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Board> boards;
}
