/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consoleroulette;

/**
 *
 * @author MaxwellShiundlana
 */
public class Player {
    public String name;
    public double amtWins;
    public double amtBets;
    public double amtProfit;

    public Player(String name, double amtBets, double amtWins){
        this.name = name;
        this.amtWins = amtWins;
        this.amtBets = amtBets;
    }

    public double totalBets(){
        return amtBets;
    }

    public double totalWins(){
        return amtWins;
    }

    public double totalProfit(){
        return amtWins - amtBets;
    }

    public void setWins(double win){
        amtWins += win;
    }

    public void setBets(double bet){
        amtBets += bet;
    }    
}
