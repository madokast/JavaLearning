package Collection;

import java.util.HashSet;

public class Card {
    private HashSet<String> cards;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i=0;
        for (String s : cards) {
            i++;
            sb.append(s);
            sb.append(' ');
            if(i%10==0){
                sb.append('\n');
            }
        }

        return sb.toString();
    }


    public Card(){
        cards = new HashSet<>(52);
        cards.add("大王");
        cards.add("小王");

        String[] mode = {"♠","♥","♣","♦"};
        String[] num = new String[13];
        for(int i=0;i<10;i++){
            num[i]=String.valueOf(i+1);
        }
        num[10] = "J";
        num[11] = "Q";
        num[12] = "K";

        for(int i=0;i<num.length;i++){
            for(int j=0;j<mode.length;j++){
                cards.add(mode[j]+num[i]);
            }
        }
    }
}
