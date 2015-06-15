

package deck.d.out.war;

public class Player extends Queue<Card> {
    private int size = 0;
    private String name;
    
    public Player(String name){
        this.name = name;  
    }
    public String getName(){
        return name;
    }
    public int getSize(){
        return size;
    }
    public void addCard(Card c){
        size++;
        put(c);  
    }
    public Card playCard() {
        size--;
        return get();       
    }
    public String toString(){
        return name + ": " + size + " cards";
    }
        
    
    
    
}
