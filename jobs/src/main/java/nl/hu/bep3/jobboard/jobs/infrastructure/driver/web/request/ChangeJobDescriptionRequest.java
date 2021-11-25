package nl.hu.bep3.jobboard.jobs.infrastructure.driver.web.request;

import javax.validation.constraints.NotBlank;

public class ChangeJobDescriptionRequest {
    @NotBlank
    public String description;
}
