package Test;

import java.util.LinkedList;
import java.util.List;

public class Nonrecu {
    public static void main(String[] args) {
        System.out.println("recu(4) = " + recu(12));
        System.out.println("nonrecu(4) = " + nonrecu(12));
    }
    
    public static int nonrecu(int n){
        LinkedList<BiNum> st = new LinkedList<>();
        st.push(new BiNum(n,n));
        
        while(st.getFirst().index>1){
            n--;
            st.push(new BiNum(n,n));
        }
        
        while(st.size()>1){
            BiNum last = st.pop();
            BiNum lastButOne = st.pop();
            st.push(new BiNum(0,last.value*lastButOne.value));
        }
        
        return st.pop().value;
    }
    

    public static int recu(int n){
        if(n==1)
            return 1;

        return n*recu(n-1);
    }
    
    public static class BiNum{
        int index;
        int value;

        public BiNum(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
