package nl.hu.bep3.jobboard.jobs.infrastructure.driver.web.request;

import javax.validation.constraints.NotBlank;

public class PostJobRequest {
    @NotBlank
    public String company;

    @NotBlank
    public String function;

    @NotBlank
    public String description;
}
