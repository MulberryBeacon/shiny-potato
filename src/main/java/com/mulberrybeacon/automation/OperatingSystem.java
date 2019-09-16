package com.mulberrybeacon.automation;

/**
 * Operating systems supported by the Chrome Web Driver.
 */
public enum OperatingSystem {

    WINDOWS     ("win32"),
    LINUX       ("linux64"),
    MACOS       ("mac64"),
    UNSUPPORTED ("");

    private String directory;

    OperatingSystem(final String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }
}
