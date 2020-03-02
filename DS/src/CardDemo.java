import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class Card{
    public int rank;
    public String color;
    @Override
    public String toString() {
        String str=null;
        if(rank==1){
            str="A";
        }else if(rank>10){
            if(rank==11)
                str="J";
            if(rank==12)
                str="Q";
            if (rank==13)
                str="K";
        }
    else {
        str=String.valueOf(rank);
        }
    return String.format("%s,%s",str,color);
    }
}
public class CardDemo {
    private static final String colors[]={"♠", "♥", "♣", "♦"};
    public static List<Card> buycard(){
        List<Card> deck=new ArrayList<>(52);
        for(int i=0;i<4;i++){
            for(int j=0;j<=13;j++){
                String colorss=colors[i];
                int rank=j;
                Card card=new Card();
                card.rank=rank;
                card.color=colorss;
                deck.add(card);
            }
        }
        return  deck;
    }
    public static void shuffle(List<Card> deck ){
        Random random=new Random();
        for(int i=deck.size()-1;i>0;++i){
            int pos= random.nextInt(i);
            swap(deck,i,pos);
        }
    }
    public  static  void swap(List<Card> deck,int i,int j){
        Card temp=deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,temp);
    }

    public static void main(String[] args) {
        List<Card> deck = buycard();
        System.out.println(deck);
        List<List<Card>> hands = new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println(deck);
        System.out.println(hands.get(0));
        System.out.println(hands.get(1));
        System.out.println(hands.get(2));
    }
}
