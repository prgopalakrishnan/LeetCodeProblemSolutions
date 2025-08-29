import java.util.*;

public class RevealCardsIncreasingOrder {
	    int[] result = null;
	    public int[] deckRevealedIncreasing(int[] deck) {
	            return helper(deck, 0);
	    }

	    public int[] helper(int[] deck, int idx) {
	        if(result != null && result.length > 0) {
	                return result;
	        }
	        if(isInorder(deck)) {
	        	System.out.println("inside");
	            result = new int[deck.length];
	            for(int i =0; i < deck.length; i++) {
	                result[i] = deck[i];
	            }
	            return result;
	        }

	        
	        for(int i = idx; i < deck.length; i++) {
	            helper(deck, idx+1);
	            if(result != null && result.length > 0) {
	            	return result;
	            }
	            
	            swap(deck, idx, i);
	            helper(deck, idx+1);
	            if(result != null && result.length > 0) {
	            	return result;
	            }
	            
	            swap(deck, idx, i);
	        }

	        return new int[0];
	    }

	    public void swap(int[] deck, int srcIdx, int dstIdx) {
	        int tmp = deck[srcIdx];
	        deck[srcIdx] = deck[dstIdx];
	        deck[dstIdx] = tmp;
	    }


	    public boolean isInorder(int[] deck) {
	        
	        boolean inOrder = true;
	        Queue<Integer> q = new LinkedList();
	        for(int i = 0; i < deck.length; i++) {
	            q.offer(deck[i]);
	        }

	        int prevElem = 0;
	        int curElem = 0;
	        while(q.size() > 1) {
	            
	            prevElem = q.poll();
	            curElem = q.poll();
	            if(q.size() == 0) {
	                return (prevElem <= curElem);
	            }
	            if(prevElem > q.peek()) {
	                inOrder = false;
	                break;
	            } else {
	                q.offer(curElem);
	            }
	        }
	        return inOrder;
	    }
	    
	    
	    
	    public static void main(String args[]) {
	    	RevealCardsIncreasingOrder obj = new RevealCardsIncreasingOrder();
	    	int[] deck = new int[] {17,13,11,2,3,5,7};
	    	obj.deckRevealedIncreasing(deck);
	    }

}
