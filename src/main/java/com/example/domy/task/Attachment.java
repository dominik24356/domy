package com.example.domy.task;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String link;

    private String displayText;

    private Date createdAt;
}
