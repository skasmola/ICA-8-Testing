import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class urinalsTest {

    @Test
    void TestUrinalInput(){
        assertEquals("3",urinals.countUrinals("00000"));
    }

    @Test
    void TestInvalidInput(){
        assertEquals("Please Enter Valid Input",urinals.countUrinals("jdvbbhj"));
    }

    @Test
    void TestNegativeUrinalInput(){
        assertEquals("-1",urinals.countUrinals("011"));
    }

    @Test
    void TestFileExists(){
        urinals u = new urinals();
        assertEquals("urinals.dat",u.readFile("urinals.dat"));
    }

    @Test
    void TestFileDoesntExist(){
        urinals u = new urinals();
        assertEquals("urinals.dat",u.readFile("urinals.dat"));
    }

    @Test
    void TestFileEmpty(){
        urinals u = new urinals();
        assertEquals("File is empty, please enter a valid file",u.readFile(""));
    }



}
