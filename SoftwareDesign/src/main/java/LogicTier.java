import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LogicTier {

  private final DataTier dataTier; // link to the Data Tier

  public LogicTier(DataTier dataTier) {
    this.dataTier = dataTier;
  }

  public List<String> findBookTitlesByAuthor(String author) throws FileNotFoundException {
    List<Book> books = dataTier.getAllBooks();
    List<String> titles = new ArrayList<>();

    for (Book book : books) {
      if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
        titles.add(book.getTitle().replaceAll("[\"]", ""));
      }
    }

    return titles;
  }

  public int findNumberOfBooksInYear(int year) throws FileNotFoundException {
    List<Book> books = dataTier.getAllBooks();
    int numOfBooksInYear = 0;

    for (Book book : books) {
      if (book.getPublicationYear() == year) {
        numOfBooksInYear++;
      }
    }

    return numOfBooksInYear;
  }

}
