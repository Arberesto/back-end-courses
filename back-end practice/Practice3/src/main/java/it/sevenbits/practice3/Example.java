package it.sevenbits.practice3;

import java.io.IOException;

/**
 * Works with FileReader and analyze text
 */
class Example {

    /**
     * Analyze file and return length of longest line
     * @param reader FileReader used for getting lines from file
     * @return Number of symbols in longest text line from file
     * @throws IOException when can't read from reader or there is inner problems in reader
     */
    int getLongestLineCharsCount(final FileReader reader) throws IOException {
        int maxLength = 0;
        reader.reset();
        while (reader.hasMoreLines()) {
            String line = reader.readLine();
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        return maxLength;
    }
}
