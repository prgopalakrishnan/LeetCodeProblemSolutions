/**
 * We want to simulate a children’s card game, war. 
 * There are 52 cards, each with a number from 1 to 52 
 * (no suits), and two players. You should deal the cards r
 * andomly, evenly to the players. Then, in each round, the 
 * players play their first card and the player with the higher card gets a point,
 *  and then the cards are discarded. At the end of the game, output the winning player and the scores.
 * @author priyagopalakrishnan
 * 
 * 1. Divide cards into 2 sets
 * 2. Loop 26 times to find winner
 *
 */

import java.util.*;


public class ChildrenWarGame {
	
	
	public  List<List<Integer>> divideCards(int n, int mplayers) {
		List<List<Integer>> result = new ArrayList();
		
		Set<Integer> numSet = new HashSet();
		Random rand = new Random();
		

		int numCards = n/mplayers;
		
		for(int i = 0; i < mplayers; i++) {
			result.add(new ArrayList());
		}
		
		for(int i = 0; i < mplayers; i++) {
			while(result.get(i).size() != numCards) {
				int num = rand.nextInt(n);
				System.out.println(" Number generated = " +num );
				if(num != 0 && !numSet.contains(num)) {
					numSet.add(num);
					result.get(i).add(num);
				}
			}
			System.out.println("Player " + i + " size = "+result.get(i).size());
		}

		return result;
	}
	
	
	public void playGame(int NCards, int MPlayers) {
		List<List<Integer>> lists = divideCards(NCards, MPlayers);
		
		List<List<Integer>> playerList = new ArrayList();

		int[]  player1Pts = new int[MPlayers];


		for(int i = 0; i < 26; i++) {
			int maxIndex = maxPlayerIndex(playerList, i);
			player1Pts[maxIndex]++;
			
		}
		
		int winnerIndex = findWinner(player1Pts);
		System.out.println( "Winner = Player"+winnerIndex);
		
	}
	
	
	public int findWinner(int[] player1Pts) {
		int index = 0;
		int max = 0;
		for(int i = 0; i < player1Pts.length; i++) {
			if(max < player1Pts[i]) {
				max = player1Pts[i];
				index = i;
				
			}
		}
		return index;
	}
	
	public int maxPlayerIndex(List<List<Integer>> playerList, int curIndex) {
		int maxPlayerIndex = 0;
		int maxPoint = 0;
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(curIndex).get(i) > maxPoint) {
				maxPoint = playerList.get(curIndex).get(i);
				maxPlayerIndex = i;
			}
		}
		return maxPlayerIndex;
	}
	
	
	public static void main(String args[]) {
		System.out.println("Hello");
		ChildrenWarGame game = new ChildrenWarGame();
		game.playGame(53, 2);
	}

}
