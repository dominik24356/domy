package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.task.Task;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    @Column(length = 100)
    @Size(max = 100)
    @NotBlank
    private String listName;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @JsonBackReference
    private Board board;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks;


    public void addTask(String taskName) {
        Task task = Task.builder()
                .taskName(taskName)
                .status(Task.TaskStatus.TODO)
                .taskList(this)
                .build();

        tasks.add(task);
    }
}
