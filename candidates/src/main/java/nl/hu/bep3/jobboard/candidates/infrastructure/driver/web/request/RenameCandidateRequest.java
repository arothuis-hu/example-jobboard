package nl.hu.bep3.jobboard.candidates.infrastructure.driver.web.request;

import javax.validation.constraints.NotBlank;

public class RenameCandidateRequest {
    @NotBlank
    public String name;
}
