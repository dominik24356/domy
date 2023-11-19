package com.example.domy.user;

import com.example.domy.tasklist.TaskList;
import jakarta.persistence.*;
import lombok.Data;

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
    private List<TaskList> taskLists;
}
