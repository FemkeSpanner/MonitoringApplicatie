package Project_Monitoring;

import javax.swing.*;
import java.util.ArrayList;

public class Infrastructuur {
    private ArrayList<Hardwarecomponent> componenten = new ArrayList<Hardwarecomponent>();
    private ImageIcon afbeeldingRouter = new ImageIcon("src/Project_Monitoring/router.png");

    //constructor
    public Infrastructuur(){
      componenten.add(new Hardwarecomponent(1));
      componenten.add(new Hardwarecomponent(2));
      componenten.add(new Hardwarecomponent(3));
      componenten.add(new Hardwarecomponent(4));

    }


    //getters

    public ImageIcon getAfbeeldingRouter() {
        return afbeeldingRouter;
    }
    public ArrayList<Hardwarecomponent> getComponenten() {
        return componenten;
    }
}
