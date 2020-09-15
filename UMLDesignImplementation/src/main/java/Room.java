public class Room extends MapSite{

  public int roomNumber;
  public Wall[] sides;
  public MapSite[] mapsites;

  public Room () {
    this.roomNumber = 0;
    this.sides = new Wall[1];
    this.mapsites = new MapSite[1];
  }

  public Wall getSide(int roomNumber) {
    return sides[0];
  }

  public void setSide(int roomNumber, Wall wall) {

  }

}
