package net.javaguides.service;

import net.javaguides.model.Content;
import java.util.List;

public interface ContentService {

    Content saveContent(Content content);

    List<Content> getAllContents();
}
