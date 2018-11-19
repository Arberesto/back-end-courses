package it.sevenbits.practice3;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;

/**
 * This class used to start program
 */
final class Main {
    private Main(){}

    /**
     * Entry point of program
     * @param args arguments of command line (not used)
     */
    public static void main(final String[] args) {
        try {
            File dir = new File(".");
            String path = dir.getAbsoluteFile().getParent();
            File firstFile = new File(path + "/Homework3.txt");
            InputStream fileInputStream = new FileInputStream(firstFile);
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            File secondFile = new File(path + "/MyHomework.txt");
            if (!secondFile.exists()) {
                if (!secondFile.createNewFile()) {
                    throw new FileAlreadyExistsException("Can't open second file");
                }
            }
            OutputStream fileOutputStream = new FileOutputStream(secondFile);
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            long length = firstFile.length();
            byte[] buffer = new byte[(int) length];
            String stringRead = new String(buffer, Charset.forName("utf-8"));
            bufferedOutputStream.write(stringRead.getBytes(Charset.forName("utf-8")));
            bufferedOutputStream.flush();
            String lastNameString = "\nБагаев";
            byte[] lastName = lastNameString.getBytes(Charset.forName("utf-8"));
            bufferedOutputStream.write(lastName);
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (FileAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't read from or write into file");
        }
    }
}
