package com.example.domy.task.label;

import com.example.domy.board.BoardService;
import com.example.domy.task.label.dto.LabelCreateRequest;
import com.example.domy.task.label.dto.LabelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/api")
public class LabelController {

    private final LabelService labelService;

    private final BoardService boardService;


    public LabelController(LabelService labelService, BoardService boardService) {
        this.labelService = labelService;
        this.boardService = boardService;
    }


    @PostMapping("/boards/{boardId}/labels")
    @PreAuthorize("@boardService.isBoardOwner(authentication, #boardId) OR hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> createLabel(@PathVariable Long boardId, @Valid @RequestBody LabelCreateRequest labelCreateRequest) {
        LabelDto label = labelService.createLabel(boardId, labelCreateRequest);

         return ResponseEntity.created(URI.create("/api/labels/" + label.getLabelId())).build();
    }

    @GetMapping("/labels/{labelId}")
    @PreAuthorize("@labelService.isLabelOwner(authentication, #labelId) OR hasRole('ROLE_ADMIN')")
    public ResponseEntity<LabelDto> getLabelById(@PathVariable Long labelId) {
        return ResponseEntity.ok(labelService.getLabelById(labelId));
    }



}
