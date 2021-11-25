package nl.hu.bep3.jobboard.jobs.infrastructure.driver.web.request;

import javax.validation.constraints.NotBlank;

public class ChangeJobFunctionRequest {
    @NotBlank
    public String function;
}
