package net.javaguides.controller;

import org.springframework.web.bind.annotation.*;
import net.javaguides.model.Content;
import net.javaguides.service.ContentService;
import java.util.List;

@RestController
@RequestMapping("/api/contents")
@CrossOrigin("*")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    // POST: save single object
    @PostMapping
    public Content save(@RequestBody Content content) {
        return contentService.saveContent(content);
    }

    // GET: fetch all objects
    @GetMapping
    public List<Content> getAll() {
        return contentService.getAllContents();
    }
}

