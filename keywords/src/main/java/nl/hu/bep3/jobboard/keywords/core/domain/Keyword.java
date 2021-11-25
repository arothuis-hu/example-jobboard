package nl.hu.bep3.jobboard.keywords.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/*
    Docs:
    https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.repositories.queries
 */
@Document
public class Keyword {
    @Id
    private String keyword;

    @Indexed
    private Set<String> candidates;

    @Indexed
    private Set<String> jobs;

    public Keyword(String keyword) {
        this.keyword = keyword;
        this.candidates = new HashSet<>();
        this.jobs = new HashSet<>();
    }

    public void addCandidate(UUID candidateId) {
        this.candidates.add(candidateId.toString());
    }

    public void removeCandidate(UUID candidateId) {
        this.candidates.remove(candidateId.toString());
    }

    public void addJob(UUID jobId) {
        this.jobs.add(jobId.toString());
    }

    public void removeJob(UUID jobId) {
        this.jobs.remove(jobId.toString());
    }

    public String getKeyword() {
        return keyword;
    }

    public Set<String> getCandidates() {
        return candidates;
    }

    public Set<String> getJobs() {
        return jobs;
    }
}
