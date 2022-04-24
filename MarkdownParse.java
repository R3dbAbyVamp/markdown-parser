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
        System.out.println(currentIndex);

        while(currentIndex < markdown.length()) {

            // Check if character is blank space. If yes, skip it.
            if (markdown.substring(currentIndex, currentIndex+1).equals("\n")) {
                currentIndex++;
            }

            // System.out.println("hey ");

            System.out.println("length of file: " + markdown.length());


            int openBracket = markdown.indexOf("[", currentIndex);
            System.out.println("openBracket: " + openBracket);

            if (openBracket == -1) {
                int openBracket = markdown.indexOf("[", currentIndex);
                System.out.println("openBracket: " + openBracket);
                break;
            }

            int closeBracket = markdown.indexOf("]", openBracket);
            System.out.println("closeBracket: " + closeBracket);

            int openParen = markdown.indexOf("(", closeBracket);
            System.out.println("openParen: " + openParen);

            // Check if there is open parentheses after the first open parentheses 

            int closeParen = markdown.indexOf(")", openParen);
            System.out.println("closeParen: " +closeParen);

            

            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            System.out.println(currentIndex);
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
