import java.util.*;

public class WordSearch2 {
	    
	    public List<String> findWords(char[][] board, String[] words) {
	        List<String> resultList = new ArrayList();

	        boolean isPresent = false;
	        int rows = board.length;
	        int cols = board[0].length;
	        int curRow = 0;
	        int curCol = 0;
	        int index = 0;

	        boolean[][] visited = new boolean[rows][cols];
	        for(int i = 0; i < words.length; i++) {
	            for(int j = 0; j < rows; j++) {
	                for(int k = 0; k < cols; k++) {
	                    if(board[j][k] == words[i].charAt(0)) {
	                        visited = new boolean[rows][cols];
	                        index = 0;
	                        isPresent = helper(board, words[i], visited, rows, cols, j, k, index);
	                        System.out.println("isPresent = "+isPresent+" for word = "+words[i]+" row = "+j+" col = "+k);
	                        if(isPresent) {
	                            resultList.add(words[i]);
	                            break;
	                        }
	                    }
	                }
	                if(isPresent) {
						isPresent = false;
	                    break;
	                }
	            }
	            
	        }

	        return resultList;
	    }

	    public boolean helper(char[][] board, String word, boolean[][] visited,
	                            int rows, int cols, int curRows, int curCols, int index) {
	        // if(word.equals("gfedcbaaa")) {
	        //     System.out.println(" word = "+word+ " curRows = "+curRows+" curCols = "+curCols+" index = "+index);
	        // }
	        
	        if(index >= word.length()) {
	            return true;
	        }

	        if(curRows < 0 || curRows >= rows || curCols < 0 || curCols >= cols) {
	            return false;
	        }

			if(board[curRows][curCols] != word.charAt(index)) {
	            return false;
	        }

	        if(visited[curRows][curCols]) {
	            return false;
	        }

	        visited[curRows][curCols] = true;
			if(word.equals("gfedcbaaa")) {
				System.out.println("visited char = "+board[curRows][curCols]+" curRows "+curRows+ " curCols "+curCols);
			}
	        

	        int[] dir = {-1, 1};

	        return (helper(board, word, visited, rows, cols, curRows, curCols+dir[0], index+1) ||
	                helper(board, word, visited, rows, cols, curRows, curCols+dir[1], index+1) ||
	                helper(board, word, visited, rows, cols, curRows+dir[0], curCols, index+1) ||
	                helper(board, word, visited, rows, cols, curRows+dir[1], curCols, index+1)
	            );


	    }
	    
	    public static void main(String args[]) {
	    	char[][] board = 
				{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
				//board=[["a","b","c"],["a","e","d"],["a","f","g"]]
				//words=["abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"]
	    	
	    	String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
	    	WordSearch2 ws = new WordSearch2();
	    	List<String> resultList = ws.findWords(board, words);
	    	System.out.println(resultList);
	    }
	    
	    
	}



