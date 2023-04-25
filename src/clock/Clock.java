/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author Mihajlo
 */
public class Clock extends Thread {
    private JLabel lblClock;

    public Clock(JLabel lblClock) {
        this.lblClock = lblClock;
        start();
    }

    public JLabel getLblClock() {
        return lblClock;
    }

    public void setLblClock(JLabel lblClock) {
        this.lblClock = lblClock;
    }

    @Override
    public void run() {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
        while(true){
            LocalTime time=LocalTime.now();
            lblClock.setText(dtf.format(time));
        }
    }
    
}
