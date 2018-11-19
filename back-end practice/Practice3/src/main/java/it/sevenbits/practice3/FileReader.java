package it.sevenbits.practice3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.EOFException;
import java.nio.charset.Charset;

/**
 * Buffered reader from file stream
 */

class FileReader {

    private String filename;
    private Reader fileReader;
    private int lineNumber;
    private int nextLine;

    /**
     * Buffered reader from file
     * @param file File object represents file to read from
     * @throws IOException if can't open file or can't read from it
     */

     FileReader(final File file) throws IOException {
        InputStream fileInputStream = new FileInputStream(file);
        InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        fileReader = new InputStreamReader(bufferedInputStream, Charset.forName("utf-8"));
        filename = file.getName();
        lineNumber = 1;
        nextLine = fileReader.read();
    }

    /**
     * Read one line from file
     * @return String that contain one line from file with prefix "filename line X:" where X - line number
     * @throws IOException when can't read from file or another inner problem in fileReader
     * @throws EOFException  when tried to read when there is no lines
     */

    String readLine() throws IOException {
        if (hasMoreLines()) {
            StringBuilder sb = new StringBuilder();
            sb.append(filename).append(" line ").append(lineNumber).append(":");
            if (nextLine != '\n') {
                sb.append((char) nextLine);
                nextLine = fileReader.read();
                while ((nextLine != -1) && (nextLine != (int) '\n')) {
                    sb.append((char) nextLine);
                    nextLine = fileReader.read();
                }
            }
            lineNumber++;
            nextLine = fileReader.read();
            return sb.toString();
        }
        throw new EOFException();
    }

    /**
     * Check if file contain line to read
     * @return if has another line to read - true, else - false
     */

    boolean hasMoreLines() {
        return nextLine != -1;
    }

    /**
     *
     * @throws IOException if reset is not supportable or can't read first element in file
     */
    void reset() throws IOException {
        fileReader.reset();
        lineNumber = 1;
        nextLine = fileReader.read();
    }
}
