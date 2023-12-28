package com.example.domy.task;

import com.example.domy.tasklist.TaskList;
import com.example.domy.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Task {

    public enum TaskStatus {
        TODO,
        IN_PROGRESS,
        COMPLETED,
        ON_HOLD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @NotBlank
    private String taskName;
    private String description;
    private Date dueDate;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private TaskList taskList;

    @ManyToMany
    @JoinTable(
            name = "task_assignments",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> assignedUsers;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Label> labels;

    public Task() {

    }
}
