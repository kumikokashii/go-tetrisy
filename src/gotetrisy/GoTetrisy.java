
package gotetrisy;

import gotetrisy.model.Manager;
import gotetrisy.view.Window;
import gotetrisy.controller.Controller;


public class GoTetrisy {
  public static void main(String[] args) {
    Manager mngr = new Manager();

    Window window = new Window();
    window.setManager(mngr);

    Controller cntr = new Controller();
    window.setController(cntr);

    cntr.setManager(mngr);
    cntr.setWindow(window);
    
    window.setVisible(true);
  }

}
