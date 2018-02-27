
public class GoTetrisy {
  public static void main(String[] args) {
    Manager mngr = Manager.getInstance();
    mngr.setupNewPiece();

    Window window = Window.getInstance();
    window.setManager(mngr);

    Controller cntr = Controller.getInstance();
    window.setController(cntr);

    cntr.setManager(mngr);
    cntr.setWindow(window);
    
    window.setVisible(true);
    cntr.setOn();
  }

}
