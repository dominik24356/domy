package com.example.domy.user;

import com.example.domy.board.Board;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 100)
    @Size(max = 100)
    @NotBlank
    private String username;

    @Column(length = 100)
    @Size(max = 100)
    @NotBlank
    private String login;

    @Column(length = 100)
    @Size(max = 100)
    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Board> boards;
}
