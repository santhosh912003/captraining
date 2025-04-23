package Search;

public class Q11 {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox",
            "Jumped over the lazy dog",
            "Hello World"
        };
        System.out.println(findSentenceWithWord(sentences, "World")); 
    }
}