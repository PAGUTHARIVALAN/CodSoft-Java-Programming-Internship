import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Enter text or provide a file path:");
        String input = scanner.nextLine();
        
        String text = "";
        if (input.endsWith(".txt")) { 
            try {
                text = readFile(input);
            } catch (FileNotFoundException e) {
                System.err.println("File not found!");
                return;
            }
        } else {
            text = input;
        }

        
        String[] words = text.split("\\s+|\\p{Punct}+");
        
       
        int wordCount = words.length;

        
        System.out.println("Total words: " + wordCount);

        

       
        List<String> stopWords = Arrays.asList("the", "and", "or", "a", "an", "is", "are", "on", "in"); 
        int nonStopWordCount = 0;
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                nonStopWordCount++;
            }
        }
        System.out.println("Total non-stop words: " + nonStopWordCount);

        // 8. Provide statistics like number of unique words or frequency of each word
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            String cleanWord = word.toLowerCase();
            if (!stopWords.contains(cleanWord)) {
                wordFrequency.put(cleanWord, wordFrequency.getOrDefault(cleanWord, 0) + 1);
            }
        }
        System.out.println("Total unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

      
    }

    
    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return content.toString();
    }
}
