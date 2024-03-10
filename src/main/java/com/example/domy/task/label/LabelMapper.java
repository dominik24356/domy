package com.example.domy.task.label;

import com.example.domy.task.label.dto.LabelDto;
import com.example.domy.task.mapper.CommentMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = CommentMapper.class)
public interface LabelMapper {

    LabelDto mapToLabelDto(Label label);
}
