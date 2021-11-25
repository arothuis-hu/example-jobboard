package nl.hu.bep3.jobboard.keywords.core.domain.exception;

public class KeywordNotFound extends RuntimeException {
    public KeywordNotFound(String message) {
        super(message);
    }
}
