/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consoleroulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author MaxwellShiundlana
 */
public class Main {
    private static boolean stopGame = false;
    private static ArrayList<Round> rounds = new ArrayList<Round>();
    private static ArrayList<Bet> bets = new ArrayList<Bet>();
    private static int round = 0;
    private static Map<String, Player> players = new HashMap<String, Player>();
    
    private static class RunTimer extends TimerTask {
        public void run() {
            roundOutcome();
        }
    }    
    
    public static void winnings(){  
        System.out.println("Player\t\tBarbaraTotal Win\tTotal Bet"); 
        System.out.println(String.format("---"));
               
        for (Map.Entry<String, Player> entry : players.entrySet()) {
            String name = entry.getKey();
            Player p = entry.getValue();
            System.out.println(String.format("%s\t\t%.2f\t%.2f", name, p.totalWins(), p.totalBets()));            
        }        
    }
    
    private static void roundOutcome(){
        round += 1; 
        System.out.println(String.format("Round %d is complete", round));
        Random rand = new Random();
        int outcome = rand.nextInt(36+1);
        ArrayList<Bet> b = new ArrayList<>(bets);
        rounds.add(new Round(round, outcome, b));
        bets.clear();     
    }
    
    public static void calculate(){
        for(Round r: rounds){
            r.print();                   
            for (Bet b: r.getBets()){
                if (!players.containsKey(b.getName())){
                    players.put(b.getName(), new Player(b.getName(), b.getBetAmt(), b.getBetOutcomeAmt()));
                }else{
                    Player p = players.get(b.getName());                   
                    p.setBets(b.getBetAmt());
                    p.setWins(b.getBetOutcomeAmt());
                    players.put(b.getName(), p);
                }
            }
        }
    }
    
    public static void main(String args[]){
	try{
            String filename = args[0];
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
              //System.out.println(data);
            }
            myReader.close();
	}
	catch (Exception e){
            System.out.println("Exception occurred trying to read in the input file ");
            System.exit(0);
	}        
        
        Timer timer = new Timer();
        RunTimer runner = new RunTimer();
        timer.schedule(runner, 30000, 30000);

        Scanner input = new Scanner(System.in);          
        System.out.println("***********START GAME***********");
        while (!stopGame){
            
            String in = input.nextLine();
              
            if (in.trim().equalsIgnoreCase("STOP")){
                stopGame = true;
                runner.cancel();
                timer.cancel();  
                timer.purge();     
                
                break;
            }
            
            try{
                String[] res = in.split(" ");
                String name = res[0];
                Object betVal = res[1];
                double amount = Double.parseDouble(res[2]);
                bets.add(new Bet(name, round, betVal, amount));
       
            } catch (Exception e){
                System.out.println("Exception" + e.toString());
            }
	}   
        System.out.println(String.format(""));
        System.out.println("***********GAME OVER***********");
        calculate();
        System.out.println(String.format(""));
        System.out.println("***********SUMMARY***********");
        winnings();
    }
}
