package com.consoleroulette;
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
        System.out.println(String.format("---"));
        System.out.println("Player\t\tBet\tOutcome\tWinnings");
        for(Bet bet: bets){
            bet.print();
        }         
    }
}

