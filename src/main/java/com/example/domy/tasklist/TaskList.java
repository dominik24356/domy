package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.task.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    private String listName;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
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
