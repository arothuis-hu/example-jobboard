package nl.hu.bep3.jobboard.keywords.infrastructure.driver.web;

import nl.hu.bep3.jobboard.keywords.core.application.KeywordsQueryHandler;
import nl.hu.bep3.jobboard.keywords.core.application.query.ListMatchesForKeyword;
import nl.hu.bep3.jobboard.keywords.core.domain.Keyword;
import nl.hu.bep3.jobboard.keywords.core.domain.exception.KeywordNotFound;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/keywords")
public class KeywordController {
    private final KeywordsQueryHandler queryHandler;

    public KeywordController(KeywordsQueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    @GetMapping("{keyword}")
    public Keyword listMatches(@PathVariable String keyword) {
        return this.queryHandler.handle(new ListMatchesForKeyword(keyword));
    }

    @ExceptionHandler
    public ResponseEntity<Void> handleCandidateNotFound(KeywordNotFound exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler
    public ResponseEntity<Void> handleDuplicate(DuplicateKeyException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
