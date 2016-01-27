/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interaction;

import javax.swing.JTextField;

/**
 *
 * @author 
 */
public class Clock extends Thread {

    JTextField tfTime;
  
    public static int i = 180;
    public static int j = 0;

    public Clock(JTextField tf) {
        this.tfTime = tf;
  
    }

    @SuppressWarnings("static-access")
    public Clock(int a) {
        this.i = a;
    }

    @Override
    public void run() {

        while (i > 0) {
            i--;
            int minute = i / 60;
            int Second = i - minute * 60;
           
            String time = minute + ":" + Second;
            if (Second < 10) {
                time = minute + ":0" + Second;
            }
            // //System.out.println(j);
            tfTime.setText(time);
            //lbGet.set;
            try {
                j++;
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
        
    }

    public int getSecond(){
        return i;
    }
    public void reset() {
        i = 600;
        j = 0;
    }

    public static String TimePlay() {
        int minute = j / 60;
        int Second = j - minute * 60;
        //String time  =  minute+":"+Second;
        String time = minute + ":" + Second;
        if (Second < 10) {
            time = minute + ":0" + Second;
        }
        return time;
    }
}
