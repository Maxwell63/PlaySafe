package com.consoleroulette;

/**
 *
 * @author MaxwellShiundlana
 */
public class Bet {

    public String getBetValStr() {
        return betValStr;
    }

    public double getBetValDbl() {
        return betValDbl;
    }

    public double getBetAmt() {
        return betAmt;
    }

    public double getBetOutcomeAmt() {
        return betOutcomeAmt;
    }

    public String getName() {
        return name;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
    
    public String getOutcome() {
        if (isWon){
            return "WON";
        }
        
        return "LOST";
    }    
    
    private String betValStr = null;
    private double betValDbl = -1.0;
    private double betAmt;
    private double betOutcomeAmt = 0;
    private String name;
    private int roundNumber;
    private boolean isWon = false;
    //private boolean isWon = false;


    public Bet(String name, int roundNumber, Object betValStr, double betAmt){
        try{
           this.betValDbl = Double.parseDouble(betValStr.toString());
        } catch(Exception ex){
            try{
                this.betValStr = betValStr.toString();
            }catch(Exception ex2){
                
            }   
        }
        
        this.betAmt = betAmt;
        this.name = name;
        this.roundNumber = roundNumber;
    }

    public void result(int outcomeNumber){       
        if (outcomeNumber == betValDbl){
            betOutcomeAmt = 36*betAmt;
            isWon = true;
        } else if (outcomeNumber%2 == 0 && betValStr != null && betValStr.trim().equalsIgnoreCase("EVEN")){
            betOutcomeAmt = 2*betAmt;
            isWon = true;
        } else if (outcomeNumber%2 == 1 && betValStr != null && betValStr.trim().equalsIgnoreCase("ODD")){
            betOutcomeAmt = 2*betAmt;
            isWon = true;
        }
    }
    
    public void print(){
        if (betValStr != null)
            System.out.println(String.format("%s\t\t%s\t%s\t%.2f", name, betValStr.toUpperCase(), getOutcome(), betOutcomeAmt));
        else
            System.out.println(String.format("%s\t\t%d\t%s\t%.2f", name, (int) betValDbl, getOutcome(), betOutcomeAmt));
    }
}
