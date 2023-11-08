/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cronometro;

/**
 *
 * @author nalis
 */
public class User {
    private String name;
    private int ranking;
    private int score;
    CronometroP gmTime;

    public User(String name, int score, CronometroP gmTime) {
        this.name = name;
        this.score = score;
        this.gmTime = gmTime;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public CronometroP getGmTime() {
        return gmTime;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void calcularRanking(){
        
    }
}
