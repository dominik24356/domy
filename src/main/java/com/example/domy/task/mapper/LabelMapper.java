package com.example.domy.task.mapper;

import com.example.domy.task.Label;
import com.example.domy.task.dto.LabelDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = CommentMapper.class)
public interface LabelMapper {

    LabelDto mapToLabelDto(Label label);
}
