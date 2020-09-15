public class Door extends MapSite{

  public boolean isOpen;
  public Room room1;
  public Room room2;

  public Door() {
    this.isOpen = false;
    this.room1 = new Room();
    this.room2 = new Room();
  }

  public void enter() {

  }

}
