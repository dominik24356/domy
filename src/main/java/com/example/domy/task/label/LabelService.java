package com.example.domy.task.label;

import com.example.domy.board.Board;
import com.example.domy.board.BoardService;
import com.example.domy.exception.EntityNotFoundException;
import com.example.domy.task.label.dto.LabelCreateRequest;
import com.example.domy.task.label.dto.LabelDto;
import com.example.domy.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LabelService {

    private final LabelRepository labelRepository;
    private final BoardService boardService;
    private final LabelMapper labelMapper;

    LabelService(BoardService boardService, LabelMapper labelMapper, LabelRepository labelRepository) {
        this.boardService = boardService;
        this.labelMapper = labelMapper;
        this.labelRepository = labelRepository;
    }


    @Transactional
    public LabelDto createLabel(Long boardId, LabelCreateRequest labelCreateRequest) {
        Board board = boardService.getBoardById(boardId);
        Label label = Label.builder()
                .name(labelCreateRequest.getName().trim())
                .color(labelCreateRequest.getColor())
                .board(board)
                .build();

        Label savedLabel = labelRepository.save(label);

        return labelMapper.mapToLabelDto(savedLabel);
    }

    public LabelDto getLabelById(Long labelId) {
        return labelMapper.mapToLabelDto(getLabelByIdInternal(labelId));
    }

    private Label getLabelByIdInternal(Long labelId) {
        return labelRepository.findById(labelId).orElseThrow(() -> new EntityNotFoundException(Label.class, "id", labelId.toString()));
    }

    public boolean isLabelOwner(Authentication authentication, Long labelId) {
        User currentUser = (User) authentication.getPrincipal();
        Label label = getLabelByIdInternal(labelId);
        return currentUser.getUserId().equals(label.getBoard().getUser().getUserId());
    }
}
