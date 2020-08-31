import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
      sentences.removeAll(Collections.singleton(null));
      for (Sentence sentence : sentences) {

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

    return words;
  }

  /**
   * This method iterates over each Word in the input Set, uses the Word’s calculateScore method to
   * get the average sentiment score for that Word, and then places the text of the Word (as key)
   * and calculated score (as value) in a Map.
   * <p>
   * If the input Set of Words is null or is empty, the calculateScores method returns an empty
   * Map.
   * <p>
   * If a Word object in the input Set is null, this method ignores it and process the non-null
   * Words.
   *
   * @param words input Set of Words extracted from the dataset.
   * @return a map of each word (key) and it's corresponding score (value).
   */
  public static Map<String, Double> calculateScores(Set<Word> words) {
    Map<String, Double> wordScoreMap = new HashMap<>();

    if (words != null) {
      words.removeAll(Collections.singleton(null));
      for (Word word : words) {
        String text = word.getText();
        Double score = word.calculateScore();

        wordScoreMap.put(text, score);
      }
    }

    return wordScoreMap;
  }

  /**
   * This method uses the Map of word scores to calculate and return the average score of all the
   * words in the input sentence and thereby the overall sentiment score of the sentence.
   * <p>
   * If a word in the sentence does not start with a letter, it is ignored, but if it starts with a
   * letter and is not present in the Map, the word score is assumed to be 0.
   * <p>
   * If the input Map is null or empty, or if the input sentence is null or empty or does not
   * contain any valid words, this method returns 0.
   *
   * @param wordScores map of each word and it's corresponding score from the dataset.
   * @param sentence input sentence
   * @return the overall sentiment score of the sentence
   */
  public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
    String regex = "^[a-zA-Z]+";
    Pattern pattern = Pattern.compile(regex);
    double sentenceScore;
    try {
      String[] inputWords = sentence.split("\\s");
      double totalWords = 0.0;
      double totalWordScore = 0.0;

      for (String word : inputWords) {

        Matcher matcher = pattern.matcher(word);

        if (matcher.find()) {
          totalWords++;
          String validWord = matcher.group().trim().toLowerCase();

          if (wordScores.containsKey(validWord)) {
            totalWordScore += wordScores.get(validWord);
          }
        }

      }

      sentenceScore = totalWordScore / totalWords;

    } catch (NullPointerException e) {
      return 0;
    }

    return Double.isNaN(sentenceScore) ? 0 : sentenceScore;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final String projectPath = Paths.get(".").normalize().toAbsolutePath().toString();
    final String DIRECTORY = projectPath + "\\src\\main\\resources\\";
    List<Sentence> sentences = Analyzer.readFile(DIRECTORY + "\\reviews.txt");
    Set<Word> words = Analyzer.allWords(sentences);
    Map<String, Double> wordScores = Analyzer.calculateScores(words);

    System.out.print("Please enter a sentence: ");

    String sentence = scanner.nextLine();
    scanner.close();

    double score = Analyzer.calculateSentenceScore(wordScores, sentence);
    System.out.println("The sentiment score is " + score);
    if (score > 1) {
      System.out.println("Highly Positive!!");
    } else if (score > 0 && score <= 1) {
      System.out.println("Somewhat Positive");
    } else if (score == 0) {
      System.out.println("Neutral");
    } else if (score < 0 && score >= -1) {
      System.out.println("Somewhat Negative");
    } else {
      System.out.println("Negative!!");
    }
  }
}
