package com.example.domy.task;

import javax.persistence.*;

@Entity
public class Label {

    public enum LabelColor {
        RED,
        GREEN,
        BLUE,
        YELLOW,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String name;

    @Enumerated(EnumType.STRING)
    private LabelColor color;


}
