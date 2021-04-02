package com.gildedrose;

import java.net.URL;

public final class IntegrationTestUtils {

    private IntegrationTestUtils() {
    }

    public static String getResourcePath(final String fileName) {
        URL outputFileURL = IntegrationTestUtils.class.getClassLoader().getResource(fileName);
        assert outputFileURL != null : String.format("%s resource missing", fileName);
        return outputFileURL.getPath();
    }
}