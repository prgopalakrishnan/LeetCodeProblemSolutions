import java.util.*;


public class NQueen {
	
	
	public static void main(String args[]) {
		NQueen nq = new NQueen();
		List<List<String>> result = nq.solveNQueens(4);
		System.out.println(result);
		
	}
	
	public List<List<String>> solveNQueens(int n) {
		
	    char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList();
        helper(n , board, 0, result);
        return result;
    }
    
    
    public void helper(int n, char[][] board, int idx, List<List<String>> result) {
        
        if(idx == n) {
            List<String> tmpResult = new ArrayList();
           for(int i = 0; i < n; i++) {
               StringBuffer buf = new StringBuffer();
               for(int j =0; j < n; j++) {
                   buf.append(board[i][j]);
               }
               tmpResult.add(buf.toString());
               //System.out.print("tmpResult = " +tmpResult);
           }
            result.add(tmpResult);
            //System.out.print("result = " +result);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!hasConflict(n, board, idx, i)) {
                board[idx][i] = 'Q';
                helper(n, board, idx+1, result);
                board[idx][i] = '.';
            } 
        }
    }
    
    public boolean hasConflict(int n, char[][] board, int irow, int col) {
        
    	
    	
        for(int row = 1; row <= irow; row++) {
        	if( ( irow-row >= 0 && board[irow-row][col] == 'Q') ||
        			(col-row >= 0 && board[irow-row][col-row] == 'Q')  ||
        			(col+row < n && board[irow-row][col+row] == 'Q') ) {
        		return true;
        	}
        }
        return false;
        
        
    }
    

}
