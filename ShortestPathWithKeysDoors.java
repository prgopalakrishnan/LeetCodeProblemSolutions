
import java.util.*;
public class ShortestPathWithKeysDoors {

     public static void main(String []args){
        System.out.println("Hello World");
        String[] words = {"...B",".b#.", "@#+."};
        //getAdjMatrix(words);
        
       // ShortestPathWithKeysDoors hw = new ShortestPathWithKeysDoors();
      int[][] out = find_shortest_path(words);
        for(int i = 0; i < out.length; i++) {
            System.out.println(out[i][0]+ " "+out[i][1]);
        }
     }
     
     
     
     
      static int[][] find_shortest_path(String[] grid) {
        
        int n = grid.length;
        int m = grid[0].length();
        
        int startRow = -1;
        int startCol = -1;
        int endRow = -1;
        int endCol = -1;

        int[][] dir = { {-1,0}, {1,0}, {0,1}, {0, -1}};
        
        //Create adjMatrix
        char[][] adjMatrix = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                adjMatrix[i][j] = grid[i].charAt(j);
                if(grid[i].charAt(j) == '@') {
                    startRow = i;
                    startCol = j;
                }
                
                if(grid[i].charAt(j) == '+') {
                    endRow = i;
                    endCol = j;
                }
            }
        }
        
        
        Queue<Node> q = new LinkedList();
        List<String> visited = new ArrayList();
        //visited.add(startRow+"_"+startCol);
        
        Node n1 = new Node(startRow, startCol, visited, new ArrayList(), 'z');
        q.add(n1);
        
        while(q.size()> 0) {
            Node tmp = q.remove();
            
           

            for(int[] curDir: dir) {
                int x = tmp.x+curDir[0];
                int y = tmp.y+curDir[1];
                
                if(x == 1 && y == 1) {
                	System.out.println("Recvd value  1 1");
                }
                
                if(x < n && x >= 0 && y < m && y >= 0 && !tmp.visited.contains(x+"_"+y)) {
                    if(adjMatrix[x][y] >= 97 && adjMatrix[x][y] < (97+26)) {
                        Node tmpNode = new Node(x,y,tmp.visited, tmp.keys, adjMatrix[x][y]);
                        q.add(tmpNode);
                    }
                    if(adjMatrix[x][y] >= 65 && adjMatrix[x][y] < (65+26) && tmp.keys.contains(Character.toLowerCase(adjMatrix[x][y])) ) {
                        Node tmpNode = new Node(x,y,tmp.visited, tmp.keys, 'z');
                        q.add(tmpNode);
                    }
                    if(adjMatrix[x][y] == '.') {
                        Node tmpNode = new Node(x,y,tmp.visited, tmp.keys, 'z');
                        q.add(tmpNode);
                    }
                    if(adjMatrix[x][y] == '+') {
                        int[][] result = new int[tmp.visited.size()+1][2];
                        for(int i =0; i < tmp.visited.size(); i++) {
                            String[] point = tmp.visited.get(i).split("_");
                            result[i][0] = Integer.parseInt(point[0]);
                            result[i][1] = Integer.parseInt(point[1]);
                        }
                        result[tmp.visited.size()][0] = x;
                        result[tmp.visited.size()][1] = y;
                        return result;
                    }
                    
                }
            }
        }
        
        return new int[0][0];
        
        
        

    }
    
     static class Node {
        public List<Character> keys = new ArrayList();
        public List<String> visited = new ArrayList();
        public int x = 0;
        public int y = 0;
        public Node(int n, int m, List<String> visited, List<Character> keys, Character key) {
            this.x = n;
            this.y = m;
            this.visited = new ArrayList();
            if(visited != null) {
                
                this.visited.addAll(visited);
                    this.visited.add(n+"_"+m);
            }
            this.keys = new ArrayList();
            if(keys != null) {
                
                this.keys.addAll(keys);
                if(key != 'z') {
                this.keys.add(key);
                }
            }
        }
        
    }



}