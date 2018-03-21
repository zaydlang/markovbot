import java.util.Scanner;
import java.io.File;

public class Run {
    public static void main(String[] args) {
        String previousWord = ".";
        Graph brain = new Graph(previousWord);
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        while (scanner.hasNextLine()) {
            Scanner line = new Scanner(scanner.nextLine());
            
            while (line.hasNext()) {
                String word = line.next();
                brain.add(previousWord, word);
                previousWord = word;
                
                if (word.charAt(word.length() - 1) == '.') {
                    brain.add(previousWord, ".");
                    previousWord = word;
                }
            }
        }
        
        brain.recurse();
    }
}
