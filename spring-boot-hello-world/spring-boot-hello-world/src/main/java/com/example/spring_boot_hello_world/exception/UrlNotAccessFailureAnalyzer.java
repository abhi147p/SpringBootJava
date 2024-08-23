package com.example.spring_boot_hello_world.exception;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class UrlNotAccessFailureAnalyzer extends AbstractFailureAnalyzer<UrlAccessException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, UrlAccessException cause) {
        return new FailureAnalysis("Unable to access the Url "+ cause.getUrl(), "Ensure the url is accessible", cause);
    }
}
