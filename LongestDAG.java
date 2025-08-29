

import java.util.*;


public class LongestDAG {
	
	public static void main(String args[]) {
		
		int[] r = find_longest_path(3, new int[] {3,2}, new int[] {2,1}, new int[] {2000000000,2000000000}, 3,1);
		for(int i =0; i < r.length; i++) {
			System.out.println(r[i]);
		}


	}

	
static int[] find_longest_path(int dag_nodes, int[] dag_from, int[] dag_to, int[] dag_weight, int from_node, int to_node) {
        
        List<Integer> curPath = new ArrayList();
        
        
        if(from_node == to_node) {
            return new int[]{from_node};
        }
        
        //build graph
        Map<Integer, Map<Integer, Integer>> adjMap = new HashMap();
        for(int i = 0; i < dag_from.length; i++) {
            if(!adjMap.containsKey(dag_from[i])) {
                adjMap.put(dag_from[i], new HashMap());
            }
            adjMap.get(dag_from[i]).put(dag_to[i], dag_weight[i]);
        }
        
        
        int[] visited = new int[dag_nodes+1];
        double[] dist = new double[dag_nodes+1];
        visited[from_node] = 1;
        curPath.add(from_node);
        Result r = new Result();
        Result curRes = new Result();
        dfs(visited, adjMap, curPath, from_node, to_node, 0.0, r, dist, curRes);
        int[] result = new int[r.resultPath.size()];
        for(int i =0; i < r.resultPath.size(); i++) {
            result[i] = r.resultPath.get(i);
        }
        return result;

    }
    
    static void dfs(int[] visited, Map<Integer, Map<Integer, Integer>> adjMap, List<Integer> curPath, int src, int dst, Double curVal, Result result, double[] dist, Result curResult) {
        if(src == dst) {
            curResult.resultVal = curVal;
            if(curVal > result.resultVal) {
                result.resultVal = curVal;
                result.resultPath.clear();
                result.resultPath.addAll(curPath);
                return;
            }
        }
        
        if(adjMap.get(src) != null) {
        for(Integer neigh : adjMap.get(src).keySet()) {
            
            
                if(dist[neigh] > 0 && (dist[neigh]+curVal+adjMap.get(src).get(neigh)) <  result.resultVal) {
                    continue;
                }
                curPath.add(neigh);
                dfs(visited, adjMap, curPath, neigh, dst, curVal+adjMap.get(src).get(neigh), result, dist, curResult);
                curPath.remove(neigh);
                if((curResult.resultVal-curVal) > dist[neigh]) {
                    dist[neigh] = curResult.resultVal-curVal;
                }
            
        }
        }
    }
    
    static class Result {
        List<Integer> resultPath = new ArrayList();
        Double resultVal = 0.0;
    }
}
