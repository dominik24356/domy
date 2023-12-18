package com.example.domy.task;

import com.example.domy.tasklist.TaskList;
import com.example.domy.user.User;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;

    @Column(length = 1000)
    private String description;
    private Date dueDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private TaskList taskList;

    @ManyToMany
    @JoinTable(
            name = "task_assignments",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> assignedUsers;
}
