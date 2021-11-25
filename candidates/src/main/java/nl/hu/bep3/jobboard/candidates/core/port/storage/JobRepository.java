package nl.hu.bep3.jobboard.candidates.core.port.storage;

import java.util.List;
import java.util.UUID;

public interface JobRepository {
    List<UUID> findJobsByKeyword(String keyword);
}
