package com.gildedrose;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TexttestFixtureIT {

    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testApplication_defaultBehavior() throws IOException {
        // when
        TexttestFixture.main(new String[0]);
        // then
        assertResult_lineByLine("output-default.txt");
    }

    @Test
    void testApplication_with20daysParam() throws IOException {
        // given
        String nbDays = "20";
        // when
        TexttestFixture.main(new String[]{nbDays});
        // then
        assertResult_lineByLine("output-20-days.txt");
    }

    private void assertResult_lineByLine(String outputFileName) throws IOException {
        try (
                BufferedReader expectedResultReader = new BufferedReader(new FileReader(IntegrationTestUtils.getResourcePath(outputFileName)));
                BufferedReader actualResultReader = new BufferedReader(new StringReader(outputStreamCaptor.toString()))
        ) {
            String expectedLine = expectedResultReader.readLine();
            while (expectedLine != null) {
                String actualLine = actualResultReader.readLine();
                assertEquals(expectedLine, actualLine, String.format("\"%s\" (actual) does not match with \"%s\" (expected)", actualLine, expectedLine));
                expectedLine = expectedResultReader.readLine();
            }
            assertNull(actualResultReader.readLine(), "unexpected additional sysout lines");
        }
    }

    @AfterEach
    void tearDown() {
        // restore output stream to its original state
        System.setOut(standardOut);
    }
}