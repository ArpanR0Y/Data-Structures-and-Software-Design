import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

  /**
   * This method takes the name of the file to read and reads it one line at a time, creating
   * Sentence objects and putting them into the List. If the file cannot be opened for reading or if
   * the input filename is null, this method should return an empty List.
   *
   * @param filename path of the text file to be read.
   * @return a List containing Sentence objects.
   */
  public static List<Sentence> readFile(String filename) {
    List<Sentence> sentences = new ArrayList<>();

    Charset charset = StandardCharsets.US_ASCII;
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), charset)) {
      String line;
      while ((line = reader.readLine()) != null) {
        String regex = "(^-?[0-2][0-2]{0,2})(\\s\\b.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String review;
        int score;

        if (matcher.find()) {
          score = Integer.parseInt(matcher.group(1));
          review = matcher.group(2).trim();
          Sentence sentence = new Sentence(score, review);
          sentences.add(sentence);
        }
      }
    } catch (NoSuchFileException | NullPointerException n) {
      return sentences;
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }

    return sentences;
  }

  /**
   * This method finds all of the individual tokens/words in the text field of each Sentence in the
   * List and creates Word objects for each distinct word. The Word objects is kept track of by the
   * number of occurrences of that word in all Sentences, and the total cumulative score of all
   * Sentences in which it appears. This method then returns a Set of those Word objects.
   * <p>
   * If the input List of Sentences is null or is empty, the allWords method returns an empty Set.
   * <p>
   * If a Sentence object in the input List is null, this method ignores it and process the non-null
   * Sentences.
   *
   * @param sentences list of all the sentences from the dataset.
   * @return set of Word objects
   */
  public static Set<Word> allWords(List<Sentence> sentences) {
    Set<Word> words = new HashSet<>();
    String regex = "^[a-zA-Z]+";
    Pattern pattern = Pattern.compile(regex);

    if (sentences != null) {
      for (Sentence sentence : sentences) {
        if (sentence != null) {

          String[] token = sentence.getText().split("\\s");

          for (String word : token) {

            Matcher matcher = pattern.matcher(word);

            if (matcher.find()) {

              String validWord = matcher.group().trim().toLowerCase();
              Word newWord = new Word(validWord);
              newWord.increaseTotal(sentence.getScore());

              words.add(newWord);
            }
          }
        }
      }
    }

    return words;
  }

  /*
   * Implement this method in Part 3
   */
  public static Map<String, Double> calculateScores(Set<Word> words) {

    /* IMPLEMENT THIS METHOD! */

    return null; // this line is here only so this code will compile if you don't modify it

  }

  /*
   * Implement this method in Part 4
   */
  public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

    /* IMPLEMENT THIS METHOD! */

    return 0; // this line is here only so this code will compile if you don't modify it

  }

  /*
   * This method is here to help you run your program. Y
   * You may modify it as needed.
   */
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length == 0) {
      System.out.println("Please specify the name of the input file");
      System.exit(0);
    }
    String filename = args[0];
    System.out.print("Please enter a sentence: ");
    Scanner in = new Scanner(System.in);
    String sentence = in.nextLine();
    in.close();
    List<Sentence> sentences = Analyzer.readFile(filename);
    Set<Word> words = Analyzer.allWords(sentences);
    Map<String, Double> wordScores = Analyzer.calculateScores(words);
    double score = Analyzer.calculateSentenceScore(wordScores, sentence);
    System.out.println("The sentiment score is " + score);
  }
}
