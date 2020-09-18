import java.io.FileNotFoundException;
import java.util.Scanner;

public class PresentationTier {

  private final LogicTier logicTier; // link to the Logic Tier

  public PresentationTier(LogicTier logicTier) {
    this.logicTier = logicTier;
  }

  public void showBookTitlesByAuthor(String author) {
    try {
      System.out.println(logicTier.findBookTitlesByAuthor(author));
      System.out.println();
    } catch (FileNotFoundException e) {
      System.out.println("File not found!!");
    }
  }

  public void showNumberOfBooksInYear(int year) {
    try {
      System.out.println(logicTier.findNumberOfBooksInYear(year));
    } catch (FileNotFoundException e) {
      System.out.println("File not found!!");
    }
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the name of Author: ");
    String author = scanner.nextLine();
    showBookTitlesByAuthor(author);

    System.out.println("Enter year to get the number of books published in that year: ");
    String year = scanner.nextLine();
    try {
      showNumberOfBooksInYear(Integer.parseInt(year));
    } catch (NumberFormatException e) {
      System.out.println("Enter a valid year!!");
    }
  }
}
