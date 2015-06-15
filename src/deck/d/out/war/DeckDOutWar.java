
package deck.d.out.war;

public class DeckDOutWar {
    
    public static void main(String[] args) {
        Deck deck = new Deck();
        Board board1 = new Board();
        Board board2 = new Board();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player[] players = {player1, player2};
        Board[] boards = {board1, board2};
        deal(deck, players);
        playWar(players, boards);
    }
    public static void deal(Deck d, Player[] players){
        int handSize = 26;
        Player p1 = players[0];
        Player p2 = players[1];
        for(int i = 0; i < handSize; i++) {
            Card c1 = d.getCard();
            Card c2 = d.getCard();
            p1.addCard(c1);
            p2.addCard(c2);          
        }   
    }
    public static boolean peace = true;
    public static int round = 0;
    public static void playRound(Player[] players, Board[] boards){
        Player p1 = players[0];
        Player p2 = players[1];
        Board b1 = boards[0];
        Board b2 = boards[1];
        Card c1 = p1.playCard();
        Card c2 = p2.playCard();
        b1.add(c1);
        b2.add(c2);
        Player winner;
        System.out.println(c1.toString() + " vs. " + c2.toString());
        if(peace && (c1.getRank() == 2 || c2.getRank() == 2)){
            war(players, boards);
        }
        else if(c1.equals(c2)){
            war(players, boards);
        }
        else {
            if(c1.compareTo(c2) > 0){
                winner = p1;
            }
            else{
                winner = p2;
            }    
            while(! b1.isEmpty()){
                winner.addCard(b1.get());
            }
            while(! b2.isEmpty()){
                winner.addCard(b2.get());
            }
            System.out.println(printPlayers(players));
            peace = true;
            round++;
        }
    }
    public static void war(Player[] players, Board[] boards){
        peace = false;
        System.out.println("WAR! (Isn't that exciting?)");
        Player p1 = players[0];
        Player p2 = players[1];
        Board b1 = boards[0];
        Board b2 = boards[1];
        String s1 = "";
        String s2 = "";
        for(int i = 0; i < 3; i++){
            if(p1.getSize() > 1) {
               Card c1 = p1.playCard(); 
               b1.add(c1);
               s1 = s1 + " " + c1.toString();
            }
            if(p2.getSize() > 1) {
                Card c2 = p2.playCard();
                b2.add(c2);
                s2 = s2 + " " + c2.toString();
            }
        }
        System.out.println("Down cards: " + p1.getName() + ":" + s1 + " " + p2.getName() + ":" + s2);
    }
    public static void playWar(Player[] players, Board[] boards){
        Player p1 = players[0];
        Player p2 = players[1];
        while(! p1.isEmpty() && ! p2.isEmpty()){
            playRound(players, boards);
        }
        if(p1.isEmpty()){
              System.out.println(p2.getName() + " wins in " + round + " rounds!");
        }
        else{
              System.out.println(p1.getName() + " wins in " + round + " rounds!");
        }  
    }
    public static String printPlayers(Player[] players){
        return players[0].toString() + ", " + players[1].toString();
    }
}
