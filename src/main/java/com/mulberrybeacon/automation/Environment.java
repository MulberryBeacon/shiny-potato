package com.mulberrybeacon.automation;

import static java.lang.String.format;

/**
 * Available execution environments for the web application.
 */
public enum Environment {

    LOCALHOST  ("https://localhost:8080"),
    PRODUCTION ("https://gothambeacon.com");

    private final String url;

    Environment(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
