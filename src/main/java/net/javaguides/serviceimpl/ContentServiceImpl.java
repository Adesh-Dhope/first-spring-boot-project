package net.javaguides.serviceimpl;

import org.springframework.stereotype.Service;
import net.javaguides.model.Content;
import net.javaguides.repository.ContentRepository;
import net.javaguides.service.ContentService;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }
}
