package Project_Monitoring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusComponenten extends JDialog implements ActionListener {
    private JLabel statusCpu;
    private JLabel statusDisk;
    private JLabel statusUptime;
    private Hardwarecomponent component;
    private JLabel cpu;
    private JLabel disk;
    private JLabel uptime;
    private String cpuValue;
    private String diskValue;
    private String uptimeValue;
    private JButton refresh;


    //constructor

    public StatusComponenten(JFrame jFrame, Hardwarecomponent component){
        super(jFrame,true);
        this.component = component;
        setSize(new Dimension(300,300));
        setLayout(new GridLayout(4,2));
        setTitle("Status "+ component.getNaam());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY );



        statusCpu = new JLabel("Cpu belasting: ");
        add(statusCpu);


        setValues();
         // Kijk of componenten verbinding maken met de client


        //Labels
        cpu = new JLabel(cpuValue);
        add(cpu);

        statusDisk = new JLabel("Vrije diskruimte: ");
        add(statusDisk);

        disk = new JLabel(diskValue);
        add(disk);

        statusUptime = new JLabel("Uptime: ");
        add(statusUptime);

        uptime = new JLabel(uptimeValue);
        add(uptime);


        refresh = new JButton("refresh");
        refresh.setBackground(Color.LIGHT_GRAY);

        refresh.setFont(new Font("Verdana",Font.BOLD,10));

        add(refresh);
        refresh.addActionListener(this);





        setVisible(true);






    }


    public void setValues(){
        if(component.getHeeftVerbinding()==true){
            this.cpuValue = String.valueOf(component.getCpu()) + "%";
            this.diskValue = String.valueOf(component.getDisk()) + "%";
            this.uptimeValue = String.valueOf(component.getUptime()) + " seconden";

        }else{
            this.cpuValue = "Niet beschikbaar";
            this.diskValue = "Niet beschikbaar";
            this.uptimeValue= "Niet beschikbaar";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==refresh){
            setValues();
            cpu.setText(cpuValue);
            disk.setText(diskValue);
            uptime.setText(String.valueOf(uptimeValue));
        }
    }
}
