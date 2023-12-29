package com.example.domy.task.dto;

import com.example.domy.task.Label;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabelDto {

    private Long labelId;

    private String name;

    private Label.LabelColor color;

}
