package nl.hu.bep3.jobboard.jobs.core.domain.exception;

public class JobNotFound extends RuntimeException {
    public JobNotFound(String message) {
        super(message);
    }
}
