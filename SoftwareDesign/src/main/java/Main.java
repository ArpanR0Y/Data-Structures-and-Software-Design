import java.nio.file.Paths;

public class Main {

  public static void main(String[] args){

    String projectPath = Paths.get(".").normalize().toAbsolutePath().toString();

    DataTier dt = new DataTier(projectPath + "\\src\\main\\resources\\books.txt");
    LogicTier lt = new LogicTier(dt);
    PresentationTier pt = new PresentationTier(lt);
    pt.start();
  }

}