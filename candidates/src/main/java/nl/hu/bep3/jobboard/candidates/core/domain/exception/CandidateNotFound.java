package nl.hu.bep3.jobboard.candidates.core.domain.exception;

public class CandidateNotFound extends RuntimeException {
    public CandidateNotFound(String message) {
        super(message);
    }
}
