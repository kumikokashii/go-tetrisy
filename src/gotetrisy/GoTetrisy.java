
package gotetrisy;

import gotetrisy.controller.Controller;
import gotetrisy.model.Manager;
import gotetrisy.view.Window;


public class GoTetrisy {
  public static void main(String[] args) {
    Manager mngr = new Manager();
    Window window = new Window();
    Controller cntr = new Controller();

    window.setManager(mngr);
    window.setController(cntr);

    cntr.setManager(mngr);
    cntr.setWindow(window);
    
    window.setVisible(true);
  }

}
