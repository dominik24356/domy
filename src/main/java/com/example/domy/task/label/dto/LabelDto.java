package com.example.domy.task.label.dto;

import com.example.domy.task.label.Label;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabelDto {

    private Long labelId;

    private String name;

    private Label.LabelColor color;

}
