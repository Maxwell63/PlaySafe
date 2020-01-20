package com.consoleroulette;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author MaxwellShiundlana
 */
public class Round {
    private int roundNumber;
    private int outcome;
    private ArrayList<Bet> bets;  
    
    public Round(int roundNumber, int outcome, ArrayList<Bet> bets){
        this.roundNumber = roundNumber;
        this.outcome = outcome;
        this.bets = bets;
        
        setOutcomes();
    }
    
    private void setOutcomes(){
        for(Bet bet: bets){
            bet.result(outcome);
            System.out.println(bet.getBetOutcomeAmt());
        }       
    }
    
    public ArrayList<Bet> getBets(){
        return bets;
    }
    
    public void print(){
        
        System.out.println(String.format("Number: %d", (int) outcome));
        //System.out.println(String.format("Round %d Outcome is %.2f", roundNumber, outcome));
        System.out.println(String.format("---"));
        System.out.println("Player\t\tBet\tOutcome\tWinnings");
        for(Bet bet: bets){
            bet.print();
        }         
    }
}

