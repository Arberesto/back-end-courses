package it.sevenbits.practice3;

import org.junit.Before;
import org.junit.Test;

import java.io.EOFException;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExampleTest { // two tests for getLongestLineCharsCount
    private Example example;

    @Before
    public void SetUp() {
           this.example = new Example();
    }

    @Test
    public void testGetLongestLineCharsCount1() throws IOException {
        FileReader reader = mock(FileReader.class);
        when(reader.hasMoreLines()).thenReturn(true,true,true,false);
        when(reader.readLine()).thenReturn("testFile.txt line 1:Hello, my name is Kate",
                "testFile.txt line 2:Helo, my name is Eight","testFile.txt line 3:end");
        assertEquals(42, example.getLongestLineCharsCount(reader));
    }

    @Test
    public void testGetLongestLineCharsCount2() throws IOException {
        FileReader reader = mock(FileReader.class);
        when(reader.hasMoreLines()).thenReturn(false);
        when(reader.readLine()).thenThrow(new EOFException());
        assertEquals(0, example.getLongestLineCharsCount(reader));
    }

}
