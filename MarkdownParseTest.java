import static org.junit.Assert.*;    // Wild card import of assert methods for junit? 
import org.junit.*;       // Wild card import for junit?

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {       // Class declaration
    @Test           // Annotation that denotes test 
    public void addition() {      // Method declaration 
        assertEquals(2, 1 + 1);         // Compares expected output 2 with the result of 1+1
        
    } 
    
    // -------- Test getLinks() ----------//
    @Test 
    public void getLinksTest() throws IOException {
        // Path and filename to get string for file name
        Path fileName = Path.of("/Users/paul/Documents/Github/markdown-parser/test-file.md");
        String content = Files.readString(fileName);

        // // Try-catch block for IOException
        // try { 
        //     content = Files.readString(fileName);
        // } 
        // catch (IOException e) {
        //     System.out.println("IOException caught");
        // } 

        // What we expect
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("https://something.com"); 
        expectedOutput.add("some-thing.html");

        // Actual
        ArrayList<String> answer = MarkdownParse.getLinks(content);
        // assertArrayEquals(expectedOutput, answer);
        assertEquals(expectedOutput, answer);

    }
}