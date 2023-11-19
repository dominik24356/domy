package com.example.domy.tasklist;

import com.example.domy.task.Task;
import com.example.domy.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    private String listName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
