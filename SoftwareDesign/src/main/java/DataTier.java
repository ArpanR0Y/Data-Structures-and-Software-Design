import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTier {

  private final String fileName; // the name of the file to read

  public DataTier(String inputSource) {
    this.fileName = inputSource;
  }

  public List<Book> getAllBooks() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(fileName));
    List<Book> bookList = new ArrayList<>();

    // Each row represents one book and has the following format: [title][tab][author][tab][year]
    String regex = "(^.+)(\\t.+\\t)(\\d{4}$)";

    Pattern pattern = Pattern.compile(regex);

    while (scanner.hasNext()) {
      String title = null;
      String author = null;
      int publicationYear = 0;
      String line = scanner.nextLine();

      Matcher matcher = pattern.matcher(line);

      if (matcher.find()) {
        title = matcher.group(1).trim();
        author = matcher.group(2).trim();
        publicationYear = Integer.parseInt(matcher.group(3).trim());
      }
      bookList.add(new Book(title, author, publicationYear));
    }

    Collections.sort(bookList);

    return bookList;
  }

}
