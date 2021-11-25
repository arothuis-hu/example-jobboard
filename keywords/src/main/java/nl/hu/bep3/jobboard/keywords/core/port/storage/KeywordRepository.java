package nl.hu.bep3.jobboard.keywords.core.port.storage;

import nl.hu.bep3.jobboard.keywords.core.domain.Keyword;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/*
    Docs: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.repositories
 */
public interface KeywordRepository extends MongoRepository<Keyword, String> {
    Optional<Keyword> findByKeyword(String keyword);

    List<Keyword> findAllByCandidatesEquals(String candidateId);

    List<Keyword> findAllByJobsEquals(String jobId);
}
