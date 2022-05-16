//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        // System.out.println(currentIndex);

        boolean hasOpenBracket = markdown.indexOf("[", currentIndex) != -1;
        // System.out.println("Has open bracket: " + hasOpenBracket);

        // Check that open bracket exists in file before executing while loop.  
        // We assume that no link can exist if there is no initial open bracket
        while(currentIndex < markdown.length() && hasOpenBracket) {
        // while(currentIndex < markdown.length()) {

        // Check if character is blank space. If yes, skip it.
        while (markdown.substring(currentIndex, currentIndex+1).equals("\n")) {
            currentIndex++;
        }

        System.out.println("hi");
        System.out.println("hello");
	System.out.println("HOLA")

        // System.out.println("length of file: " + markdown.length());


        // int openBracket = markdown.indexOf("[", currentIndex);
        // System.out.println("openBracket: " + openBracket);

        // if (markdown.indexOf("[", currentIndex) == -1) {
        // int openBracket = markdown.indexOf("[", currentIndex);
        // System.out.println("openBracket: " + openBracket);
        //     break;
        // }

        int openBracket = markdown.indexOf("[", currentIndex);
        // System.out.println("openBracket: " + openBracket);

        int closeBracket = markdown.indexOf("]", openBracket);
        // System.out.println("closeBracket: " + closeBracket);

        int openParen = markdown.indexOf("(", closeBracket);
        // System.out.println("openParen: " + openParen);

        int closeParen = markdown.indexOf(")", openParen);
        // System.out.println("closeParen: " +closeParen);

        // Open bracket after close parentheses?
        // System.out.println("close parentheses is not last character in file: " + (closeParen != (markdown.length() - 1)));
        
        // System.out.println("Open bracket after close parentheses?");
        // System.out.println(markdown.substring(closeParen, closeParen + 1));  
        // System.out.println(markdown.substring(closeParen + 1, closeParen + 2));
        // System.out.println((markdown.substring(closeParen + 1, closeParen + 2)).equals("\n"));
        // if (closeParen != (markdown.length() - 1)) {
        //     System.out.println("open bracket follows closeParen?");
        //     System.out.println((markdown.substring(closeParen + 1, closeParen + 2)).equals("["));

        // }   

        // Check if there's a new line after the close parentheses. 
        // If yes, skip the search below for the actual close parentheses
        if (closeParen != (markdown.length() - 1) && 
        !(markdown.substring(closeParen + 1, closeParen + 2)).equals("\n")) {
            int closeParenFirst = closeParen; 
            closeParen = markdown.indexOf(")", closeParenFirst + 1);
            System.out.println("closeParen Actual: " +closeParen);
        } 

        toReturn.add(markdown.substring(openParen + 1, closeParen));
        currentIndex = closeParen + 1;
        System.out.println(currentIndex);
        System.out.println("hi");
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
        // System.out.println("hey ");
    }
}
