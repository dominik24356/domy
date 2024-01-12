package com.example.domy.task;

import com.example.domy.tasklist.TaskList;
import com.example.domy.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Task {

    public enum TaskStatus {
        TODO,
        IN_PROGRESS,
        COMPLETED,
        CANCELED,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @NotBlank
    @Column(length = 200)
    @Size(max = 200)
    private String taskName;
    @Column(length = 1000)
    @Size(max = 1000)
    private String description;

    private Timestamp dueDate;
    @Enumerated(EnumType.STRING)
    @NotNull
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    @JsonBackReference
    private TaskList taskList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "task_assignments",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> assignedUsers;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Label> labels;

    public Task() {

    }
}
