
import java.util.*;

public class LongestIncreasingPathinMatrix {

    public int longestPath = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> path = new ArrayList();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                visited = new boolean[rows][cols];
                path = new ArrayList();
                dfsHelper(matrix, visited, i, j, rows, cols, path);
                System.out.println("Source row = "+i+ " col = "+j+" longestPath = "+longestPath);
            }
        }
        return longestPath;
    }

    public void dfsHelper(int[][] matrix, boolean[][] visited, int currentRow,
                     int currentCol, int rows, int cols, List<Integer> path) {
        
        if(currentRow < 0 || currentRow >= rows ||  currentCol < 0 || currentCol >= cols ||
                visited[currentRow][currentCol] || 
                (path.size() > 0 && path.get(path.size()-1) > matrix[currentRow][currentCol])) {
             longestPath = (longestPath < path.size()) ? path.size() : longestPath;
             System.out.println("Current length = "+path.size());
             return;
        }

        visited[currentRow][currentCol] = true;
        path.add(matrix[currentRow][currentCol]);

        int[] xdir = {0, 0, -1, 1};
        int[] ydir = {-1, 1, 0, 0};

            for(int i = 0; i < xdir.length; i++) {
                int newRow = currentRow+xdir[i];
                int newCol = currentCol+ydir[i];
                
                dfsHelper(matrix, visited, newRow, newCol,
                    rows, cols, path);
                
            }

    }
    
    public static void main(String args[]) {
    	int[][] matrix = {{5,5,3},{2,3,6},{1,1,1}};
    	LongestIncreasingPathinMatrix sol = new LongestIncreasingPathinMatrix();
    	int length = sol.longestIncreasingPath(matrix);
    	System.out.println("length = "+length);
    }

}
