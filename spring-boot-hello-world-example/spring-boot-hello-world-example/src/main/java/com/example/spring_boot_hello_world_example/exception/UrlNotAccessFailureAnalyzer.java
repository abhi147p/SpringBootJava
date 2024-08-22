package com.example.spring_boot_hello_world_example.exception;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class UrlNotAccessFailureAnalyzer extends AbstractFailureAnalyzer<UrLAccessException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, UrLAccessException cause) {
        return new FailureAnalysis("Unable to access the Url "+ cause.getUrl(), "Ensure the url is accessible", cause);
    }
}
