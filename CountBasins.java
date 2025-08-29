import java.util.*;
public class CountBasins {
	

	     public static void main(String []args){
//	        System.out.println("Hello World");
//	        List l1 = new ArrayList();
//	        l1.add(1);l1.add(5);l1.add(2);
//	        List l2 = new ArrayList();
//	        l2.add(2);l2.add(4);l2.add(7);
//	        List l3 = new ArrayList();
//	        l3.add(3);l3.add(6);l3.add(9);
//	        List l4 = new ArrayList();
//	        l4.add(l1);l4.add(l2);l4.add(l3);
//	        System.out.println(l4);
//	        System.out.println(find_basins(l4));
	        
	        
//	        0 2 1 3
//	        2 1 0 4
//	        3 3 3 3
//	        5 5 2 1
	        
	        ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
	        group.add(Arrays.asList(0, 2, 1, 3));
	        group.add(Arrays.asList(2, 1, 0, 4));
	        group.add(Arrays.asList(3, 3, 3, 3));
	        group.add(Arrays.asList(5, 5, 2, 1));
	        System.out.println(find_basins(group));
	     }
	     
	     public static List<Integer> find_basins(List<List<Integer>> matrix) {
	        int r = matrix.size();
	        int c = matrix.get(0).size();
	        int basins = 0;
	        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	        Node[][] visited = new Node[r][c];
	        
	        
	        for(int i =0; i < r ; i++) {
	            for(int j =0; j < c; j++) {
	                if(isSink(i,j,r,c, dir, matrix)) {
	                    Node n = new Node();
	                    n.sink = basins;
	                    n.sinkVal = matrix.get(i).get(j);
	                    n.x = i;
	                    n.y = j;
	                    visited[i][j] = n;
	                    bfs(basins, n, dir, r, c, matrix, visited);
	                    basins++;
	                }
	            }
	        }
	        
	        return getOutput(basins, visited);
	    }
	    
	    static List<Integer> getOutput(int basins, Node[][] visited) {
	        int[] basinsArr = new int[basins];
	        for(int i =0; i < visited.length; i++) {
	            for(int j =0; j < visited[0].length; j++) {
	                if(visited[i][j]!=null && visited[i][j] instanceof Node) {
	                    basinsArr[visited[i][j].sink]++;
	                }
	            }
	        }
	        Arrays.sort(basinsArr);
	        List<Integer> result = new ArrayList();
	        for(int k =0; k < basinsArr.length; k++) {
	        	result.add(basinsArr[k]);
	        }
	        return result;
	    }
	    
	    
	    static void bfs(int basins, Node parent, int[][] dir, int r, int c, List<List<Integer>> matrix, Node[][] visited) {
	        
	        Queue<Node> q = new LinkedList();
	        q.add(parent);
	        while(q.size() > 0) {
	            Node curNode = q.remove();
	            for(int[] curDir : dir) {
	                int neigh_x = curNode.x+curDir[0];
	                int neigh_y = curNode.y+curDir[1];
	                if(neigh_x >=0 && neigh_x < r && neigh_y >=0 && neigh_y < c && 
	                    matrix.get(curNode.x).get(curNode.y) < matrix.get(neigh_x).get(neigh_y)) {
	                    
	                    if(visited[neigh_x][neigh_y] == null) {
	                        Node newNode = new Node();
	                        newNode.sink = basins;
	                        newNode.x = neigh_x;
	                        newNode.y = neigh_y;
	                        newNode.sinkVal = matrix.get(curNode.x).get(curNode.y);
	                        visited[neigh_x][neigh_y] = newNode;
	                        q.add(newNode);
	                    } else if(visited[neigh_x][neigh_y] != null) {
	                        Node tmpNode = visited[neigh_x][neigh_y];
	                        if(tmpNode.sink != curNode.sink && tmpNode.sinkVal > matrix.get(curNode.x).get(curNode.y)) {
	                            tmpNode.sinkVal = matrix.get(curNode.x).get(curNode.y);
	                            tmpNode.sink = curNode.sink;
	                            q.add(tmpNode);
	                        }
	                    }
	                }
	                
	            }
	        }
	    }
	    
	    static boolean isSink(int x, int y, int r, int c, int[][] dir, List<List<Integer>> matrix) {
	        boolean isSink = true;
	        for(int[] curDir: dir) {
	            int neigh_x = x+curDir[0];
	            int neigh_y = y+curDir[1];
	            if(neigh_x >=0 && neigh_x < r && neigh_y >=0 && neigh_y < c &&
	                matrix.get(x).get(y) > matrix.get(neigh_x).get(neigh_y)) {
	                    isSink = false; 
	                    break;
	            }
	        }
	        return isSink;
	    }
	    
	    
	    static class Node {
	         int sink = -1;
	         int sinkVal = -1;
	         int x = -1;
	        int y = -1;
	    }
	}


