package it.sevenbits.practice3;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class FileReaderTest   { // test only for readline
    private FileReader fileReader;
    @Before
    public void setUp() throws IOException {
        File dir = new File(".");
        String path = dir.getAbsoluteFile().getParent();
        File file = new File (path + "/testFile.txt");
        this.fileReader = new FileReader(file);
    }


    @Test
    public void testReadLine1() throws IOException {
        assertEquals("testFile.txt line 1:Hello, my name is Kate",fileReader.readLine());
        assertEquals("testFile.txt line 2:",fileReader.readLine());
        assertEquals("testFile.txt line 3:end",fileReader.readLine());
    }

}