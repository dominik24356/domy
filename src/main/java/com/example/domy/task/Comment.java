package com.example.domy.task;

import com.example.domy.user.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String content;


    private Date createdAt;

}
