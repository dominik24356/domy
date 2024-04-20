package com.example.domy.task.label;

import com.example.domy.board.Board;
import com.example.domy.task.Task;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name", "color", "board_id"})
})
public class Label {

    public enum LabelColor {
        RED,
        GREEN,
        BLUE,
        YELLOW,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(length = 100, nullable = false)
    @Size(min=1,max = 100)
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private LabelColor color;

    @ManyToMany(mappedBy = "labels")
    private Set<Task> tasks = new HashSet<>();

    public void detachLabelFromTasks() {
        for (Task task : tasks) {
            task.getLabels().remove(this);
        }
        tasks.clear();
    }


}
