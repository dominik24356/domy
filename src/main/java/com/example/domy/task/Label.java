package com.example.domy.task;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonBackReference
    private Task task;

    @Column(length = 100)
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private LabelColor color;


}
