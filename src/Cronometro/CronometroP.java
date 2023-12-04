/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cronometro;

import java.awt.event.*;
import javax.swing.*;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class CronometroP {

    public Timer time;
    public boolean pause;
    protected int miliseg;
    protected int seg;
    protected int min;
    protected int hour;
    public JLabel label;

    public CronometroP(JLabel label) {
        this.label = label;
        this.miliseg = 0;
        this.seg = 0;
        this.min = 0;
        this.hour = 0;
        this.pause = false;
    }

    public CronometroP(int hour, int min, int seg, int miliseg, JLabel label) {
        this.miliseg = miliseg;
        this.seg = seg;
        this.min = min;
        this.hour = hour;
        this.label = label;
        this.pause = false;
    }

    ActionListener accion = new ActionListener() {
        private long startTime = System.nanoTime();

        @Override
        public void actionPerformed(ActionEvent e) {
            long currentTime = System.nanoTime();
            long elapsedTimeMillis = (currentTime - startTime) / 1_000_000;
            startTime = currentTime;
            miliseg += elapsedTimeMillis;
            if (miliseg >= 1000) {
                seg++;
                miliseg %= 1000;
            }
            if (seg == 60) {
                min++;
                seg = 0;
            }
            if (min == 60) {
                hour++;
                min = 0;
            }

            TimeTags();
        }
    };

    void TimeTags() {
        String accurateTime = (hour <= 9 ? "0" : "") + hour + ":" + (min <= 9 ? "0" : "") + min + ":" + (seg <= 9 ? "0" : "") + seg + ":" + ((miliseg / 10) <= 9 ? "0" : "") + (miliseg / 10);
        this.label.setText(accurateTime);
    }

    @Override
    public String toString() {
        return (hour <= 9 ? "0" : "") + hour + ":" + (min <= 9 ? "0" : "") + min + ":" + (seg <= 9 ? "0" : "") + seg + ":" + ((miliseg / 10) <= 9 ? "0" : "") + (miliseg / 10);
    }

    public int getMiliseg() {
        return miliseg;
    }

    public int getSeg() {
        return seg;
    }

    public int getMin() {
        return min;
    }

    public int getHour() {
        return hour;
    }

}
