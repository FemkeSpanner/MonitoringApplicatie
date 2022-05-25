package Project_Monitoring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class MonitoringScherm extends JFrame implements MouseListener {
    private Infrastructuur infrastructuur;
    private JLabel webserver1;
    private JLabel webserver2;
    private JLabel databaseserver1;
    private JLabel databaseserver2;
    private JLabel router;
    private JLabel lan;
    private JLabel dmz;

    private JLabel ipW1;
    private JLabel ipW2;
    private JLabel ipD1;
    private JLabel ipD2;

    //constructor
    public MonitoringScherm(){
        this.infrastructuur = new Infrastructuur();
        this.getContentPane().setBackground(Color.decode("#007EA7") );
        setTitle("Monitoring Applicatie");
        setSize(500,500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);




        /**
         * DMZ  { Webserver1 en webserver2}  afbeelding, text en positie
         */


        dmz = new JLabel("DMZ");
        dmz.setFont(new Font("VERDANA",Font.BOLD,20));
        dmz.setBounds(900,50,50,50);
        add(dmz);

        //webserver1
        webserver1 = new JLabel(new ImageIcon((infrastructuur.getComponenten().get(2).getAfbeelding()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        webserver1.setBounds(900,100,200,200);
        webserver1.addMouseListener(this);
        add(webserver1);

        ipW1 = new JLabel("10.10.10.14");
        ipW1.setFont(new Font("VERDANA",Font.BOLD,15));
        ipW1.setBounds(900,315,200,15);
        add(ipW1);



        //webserver2
        webserver2 = new JLabel(new ImageIcon((infrastructuur.getComponenten().get(3).getAfbeelding()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        webserver2.setBounds(900,350,200,200);
        webserver2.addMouseListener(this);
        add(webserver2);

        ipW2 = new JLabel("10.10.10.15");
        ipW2.setFont(new Font("VERDANA",Font.BOLD,15));
        ipW2.setBounds(900,565,200,15);
        add(ipW2);


        /**
         * LAN {Databaseserver1 en databaseserver2}  afbeelding, text en positie
         */

        lan = new JLabel("LAN");
        lan.setFont(new Font("VERDANA",Font.BOLD,20));
        lan.setBounds(200,450,50,50);
        add(lan);

        // databaseserver1

        databaseserver1 =  new JLabel(new ImageIcon((infrastructuur.getComponenten().get(0).getAfbeelding()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        databaseserver1.setBounds(200,500,200,200);
        databaseserver1.addMouseListener(this);
        add(databaseserver1);

        ipD1 = new JLabel("192.168.1.24");
        ipD1.setFont(new Font("VERDANA",Font.BOLD,15));
        ipD1.setBounds(200,715,200,15);
        add(ipD1);
        // Databaseserver 2

        databaseserver2 =  new JLabel(new ImageIcon((infrastructuur.getComponenten().get(1).getAfbeelding()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        databaseserver2.setBounds(500,500,200,200);
        databaseserver2.addMouseListener(this);
        add(databaseserver2);

        ipD2 = new JLabel("192.168.1.27");
        ipD2.setFont(new Font("VERDANA",Font.BOLD,15));
        ipD2.setBounds(500,715,200,15);
        add(ipD2);

        /**
         * router  afbeelding
         */
        router = new JLabel(new ImageIcon((infrastructuur.getAfbeeldingRouter()).getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT)));
        router.setBounds(400,200,125,125);
        add(router);




        setVisible(true);



    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == databaseserver1){
            StatusComponenten bekijken = new StatusComponenten(this,infrastructuur.getComponenten().get(0));
        }

        if(e.getSource() == databaseserver2){
            StatusComponenten bekijken = new StatusComponenten(this,infrastructuur.getComponenten().get(1));

        }

        if(e.getSource() == webserver1){
            StatusComponenten bekijken = new StatusComponenten(this,infrastructuur.getComponenten().get(2));
        }

        if(e.getSource() == webserver2){
            StatusComponenten bekijken = new StatusComponenten(this,infrastructuur.getComponenten().get(3));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
