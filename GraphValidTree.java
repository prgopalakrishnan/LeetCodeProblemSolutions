import java.util.*;

class GraphValidTree {
     Integer visitedCnt = 0;
    public boolean validTree(int n, int[][] edges) {

        //build graph
       
        Map<Integer, List<Integer>> adjMap = new HashMap();
        boolean visited[] = new boolean[n];
        for(int i =0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            adjMap.putIfAbsent(src, new ArrayList());
            adjMap.putIfAbsent(dst, new ArrayList());
            adjMap.get(src).add(dst);
            adjMap.get(dst).add(src);
        }
        System.out.println("adjMap = "+adjMap);

        boolean result = helper(n, adjMap, 0, -1, visited);
        return (visitedCnt == n);
    }

    public boolean helper(int n, Map<Integer, List<Integer>> adjMap, int cur, 
                        int parent, boolean[] visited) {
        
        

        visited[cur] = true;
        visitedCnt++;
        System.out.println("cur "+cur+" visitedCnt = "+visitedCnt);
        if(adjMap.get(cur) != null && adjMap.get(cur).size() > 0) {
            for(Integer neigh: adjMap.get(cur)) {
                if(neigh != parent && visited[neigh] == true) {
                    return false;
                }
                if(!visited[neigh] && !helper(n, adjMap, neigh, cur, visited)) {
                    return false;
                }
            }
        }
        System.out.println("visitedCnt = "+visitedCnt);
        return true;

    }
    
    public static void main(String args[]) {
    	GraphValidTree gv = new GraphValidTree();
    	int n = 5;
    	int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    	System.out.println(gv.validTree(n, edges));
    }
}
