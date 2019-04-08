/**
 * Final Project: Deliverable 3, BlackJack game
 * Group 10: Lara Alferez, Hung-Han Chen, Neil Froggatt, Matthew Nickel
 * Class: SYST17796 Fundamentals of Software Design
 * Instructor: Liz Dancy 
 * File: Game.java
 * Purpose: A class that models the game logic for a multi-player BlackJack game
 */
package game;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    // a new game
    private String name;
    
    // constructor
    public Game(String name){
        this.name=name;
    }
    
    // main is just an entry point into the application
    public static void main(String[] args) {    
        Game game = new Game("BlackJack");
        game.play();
    }
    
    // this contains all the game setup and play logic
    public void play(){
        Scanner myScanner = new Scanner(System.in);
        int numPlayers=0;
        String playerCount;
        String bet="";
        ArrayList<Player> players = new ArrayList<Player>();
        Player newPlayer;
        boolean validSelection;
        
        // get the # of players from the user; retry until a valid number is received
        System.out.println("How many players are playing?(1, 2 or 3)");
        do{
            validSelection=false;
            playerCount=myScanner.next();
            if(validPlayerCount(playerCount)){
                validSelection=true;
                numPlayers=Integer.parseInt(playerCount);
            }else{
                System.out.println("Invalid number of players. Please select 1, 2 or 3");
            }
        }while(!validSelection);
        
        // get a unique name of greater than 0 length, for each of the players; retry until each player gets a unique and valid value
        boolean validName= false;
        for(int i=0;i<numPlayers;i++){
            do{
                validName=false;
                System.out.println("Please enter a unique name for player #"+(i+1)+":");
                name=myScanner.next();
                if((i==0  && name.length()>0) || (i>0 && uniqueName(name, players))){
                    validName=true;
                    newPlayer=new Player(name);
                    players.add(newPlayer);
                } else {
                    System.out.println("Your name is either invalid or has already been used. Please try again.");
                }
            }while(!validName);
        }
        
        // now that we have a valid # of players with valid unique names, let's play!
        System.out.println("\n\nLet's Play!\n\n");
        
        int response=1; 
        validSelection=true;
        String confirmation="";
        boolean confirmSelection=true;
        boolean outOfMoney=false;
        String playAgain="";
        String action;
    
        // create a new dealer
        Dealer myDealer=new Dealer();
        
        // play the game until the players decide not to play anymore, or one of them runs out of money
        do{ 
            //dealer gets a new deck and shuffles it
            myDealer.getNewDeck();
            myDealer.shuffle();
        
            //clear away the players' and dealer's old hands and create new empty hands
            for(Player p: players){
                p.clearHand();
            }
            myDealer.clearHand();
            
            //ask each player for their bet until they provide a valid bet
            for(Player p: players){
                System.out.println("Hello, "+p.getName());
                System.out.println("You have $"+p.getMoney()+".");
                System.out.println("You can bet between $1 and $"+p.getMoney());
                do{ 
                    System.out.println("How much would you like to bet?");
                    bet=myScanner.next();
                    System.out.println("\n");
                    validSelection=p.bet(bet);
                    if(!validSelection) System.out.println("That is an invalid selection. Please enter a number between 1 and "+p.getMoney());
                }while(!validSelection);
            }
                    
            //dealer deals two cards to each player to start;
            for(Player p:players){
                for(int i=0;i<2;i++){
                    p.hit(myDealer.dealTopCard());
                }
            }
            
            // dealer deals one initial card to the dealer to start
            myDealer.hit(myDealer.dealTopCard());

            // dealer deals to each player (hits) until they stay, fold or bust
            for(Player p:players){
                do{
                    // loop until the player confirms that they want to proceed with their action selection (hit, stay or fold)
                    do{
                        confirmSelection=true;
                        System.out.println("Hello, "+p.getName()+". You bet $"+p.getBet()+".\n");
                        System.out.println("The dealer is showing:\n"+myDealer.showHand());
                        System.out.println("for a total of: "+myDealer.handValue()+"\n");
                        System.out.println(p.getName()+" is showing:\n"+p.showHand());
                        System.out.println("for a total of: "+p.handValue());
                        System.out.println("\n"+p.getName()+", what would you like to do?");
                        System.out.println("1. Hit");
                        System.out.println("2. Stay");
                        System.out.println("3. Fold");

                        // loop until the player has made a valid action selection of 1.hit, 2.stay or 3.fold
                        do{
                            validSelection=false;
                            action=myScanner.next();
                            if(validAction(action)){
                                validSelection=true;
                            }else{
                                System.out.println("Invalid entry. Please enter 1, 2 or 3");
                            }
                        }while(!validSelection);
                        
                        // ask the player to confirm their selection
                        switch(action){
                            case "1":
                                System.out.println("You selected 1.Hit, are you sure?(y/n)");
                                break;
                            case "2":
                                System.out.println("You selected 2.Stay, are you sure?(y/n)");
                                break;
                            case "3":
                                System.out.println("You selected 3.Fold, are you sure?(y/n)");
                                break;
                        }
                        
                        // loop until the player provides a valid confirmation response
                        do{
                            validSelection=false;
                            confirmation=myScanner.next();
                            if(validConfirmation(confirmation)){
                                validSelection=true;
                                if(confirmation.equals("y")){
                                    confirmSelection=true;
                                }else{
                                    confirmSelection=false;
                                }
                            }else{
                                System.out.println("Invalid confirmation response.  Please enter y or n");
                            }
                         }while(!validSelection);  
                        
                    }while(!confirmSelection);
                    
                    System.out.println("\n\n");
                    
                    //stay, fold or hit
                    if(action.equals("2")){ //selected 2.Stay
                        break;
                    }else {
                        if (action.equals("3")){ //selected 3.Fold
                            p.setFold(true);
                            break;
                        }else{
                            if (action.equals("1")){ //selected 1.Hit
                                p.hit(myDealer.dealTopCard());
                                if(p.getBusted()){
                                    System.out.println(p.getName()+" you are showing:\n"+p.showHand());
                                    System.out.println("for a total of: "+p.handValue());
                                    System.out.println("Sorry, but you busted!\n\n");
                                    break;
                                }
                            }else{
                                System.out.println("Please enter a valid value (1, 2 or 3).");
                            }
                        }
                    }
                }while(true);                    
            }
            
            // dealer deals to dealer until hand value > 15 or dealer busts
            do {
                myDealer.hit(myDealer.dealTopCard());
                if(myDealer.getBusted()){
                    System.out.println("Dealer busted!\n");
                }
            }while(myDealer.handValue()<16);
            
            // give everyone an update on the dealer's hand and every player's hand
            System.out.println("The dealer is showing:\n"+myDealer.showHand());
            System.out.println("for a total of: "+myDealer.handValue()+"\n");
            for(Player p:players){
                System.out.println(p.getName()+" is showing:\n"+p.showHand());
                System.out.println("for a total of: "+p.handValue()+"\n");
            }
            
            // determine who won, lost, pushed and update their money and stats accordingly
            declareWinners(myDealer, players);

            // check if anyone is out of money  
            for(Player p:players){
                if(p.getMoney()==0){
                    outOfMoney=true;
                }
            }
            
            // if no one in the group is out of money, check if they want to play again
            if(outOfMoney){
                System.out.println("Game over, as someone in your group is out of money");
            }else{
                System.out.println("\n");
                System.out.println("Press 1 if your group wants to play again!");
                System.out.println("Press 2 to quit.");
                do{ //loop until user makes a valid selection of playing again or not
                    validSelection=false;
                    playAgain=myScanner.next();
                    if(validPlayAgain(playAgain)){
                        validSelection=true;
                    }else{
                        System.out.println("Invalid selection. Please select 1 or 2.");
                    }
                }while(!validSelection);
            }
        }while(playAgain.equals("1") && !outOfMoney); //play again if user picked selected to play again and they have some money        
    }
    
    public static boolean uniqueName(String name, ArrayList<Player> players){
        for(Player p:players){
            if(name.equals(p.getName())){
                return false;
            }
        }
        return true;
    }
    
    //returns the selected action number if its valid; otherwise returns 0
    public static boolean validAction(String givenActionString){
         try{
            int givenActionInt=Integer.parseInt(givenActionString);
            if(givenActionInt<1||givenActionInt>3){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            return false;
        }
    }
    
    //returns the selected action number if its valid; otherwise returns 0
    public static boolean validConfirmation(String givenConfirmation){
        try{
            if(givenConfirmation.equals("y")||givenConfirmation.equals("n")){
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }
    
    public static boolean validPlayerCount(String givenCount){
        try{
            int numPlayers=Integer.parseInt(givenCount);
            if(numPlayers>0&&numPlayers<4){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }    
    }
    
    public static boolean validPlayAgain(String playAgainString){
        try{
            int playAgainInt=Integer.parseInt(playAgainString);
            if(playAgainInt>0 && playAgainInt<3){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        } 
    }
    
    // determine who won, lost, pushed and update their money and stats accordingly
    public void declareWinners(Dealer myDealer, ArrayList<Player> players){
        for(Player p:players){
            String winLossPush;
            // check for win/loss/push 
            if(p.getBusted()||p.getFold()){ // player busted
                winLossPush="loss";
            }else{
                if(myDealer.getBusted()){//player didn't bust but dealer did
                    winLossPush="win";
                }else{
                    if(p.handValue()>myDealer.handValue()){//nobody busted and player hand value is higher
                        winLossPush="win";
                    }else{
                        if(p.handValue()==myDealer.handValue()){// nobody busted and player and dealer handvalues are equal
                            winLossPush="push";
                        }else{//nobody busted and player hand value is less than dealer handvalue
                            winLossPush="loss";
                        }
                    }
                }
            }
            // announce winners and payout appropriately
            if(winLossPush.equals("win")){
                System.out.println(p.getName()+" won!");
                p.setMoney(p.getMoney()+2*p.getBet());
                p.setHandsWon(p.getHandsWon()+1);                    
            }
            if(winLossPush.equals("loss")){
                System.out.println(p.getName()+" lost.");
                p.setHandsLost(p.getHandsLost()+1);
                if(p.getFold()){
                    p.setMoney(p.getMoney()+p.getBet()/2);
                }
            }
            if(winLossPush.equals("push")){
                System.out.println(p.getName()+" pushed.");
                p.setMoney(p.getMoney()+p.getBet());
                p.setPushes(p.getPushes()+1);
            }
            System.out.println(p.getName()+" now has $"+p.getMoney()+",");
            System.out.println("and has a win, loss, push record of W:"+p.getHandsWon()+" L:"+p.getHandsLost()+" P:"+p.getPushes()+"\n");
        }
    }
}
