package com.example.domy.task.label;

import com.example.domy.task.label.dto.LabelCreateRequest;
import com.example.domy.task.label.dto.LabelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api")
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
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


    @GetMapping("/boards/{boardId}/labels")
    @PreAuthorize("@boardService.isBoardOwner(authentication, #boardId) OR hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<LabelDto>> getLabelsByBoardId(@PathVariable Long boardId) {
        return ResponseEntity.ok(labelService.getLabelsByBoardId(boardId));
    }


    @DeleteMapping("/labels/{labelId}")
    @PreAuthorize("@labelService.isLabelOwner(authentication, #labelId) OR hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteLabel(@PathVariable Long labelId) {
        labelService.deleteLabel(labelId);
        return ResponseEntity.noContent().build();
    }


}
