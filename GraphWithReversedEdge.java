
import java.util.*;

public class GraphWithReversedEdge {
	
	public static void main(String args[]) {
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		n1.neighbours.add(n2);
		n2.neighbours.add(n1);
		
		n2.neighbours.add(n3);
		n3.neighbours.add(n2);
		
		n3.neighbours.add(n4);
		n4.neighbours.add(n3);
		
		Map<Integer, Node> m = build_other_graph(n1);
		for(Integer n: m.keySet() ) {
			System.out.println(n+" = "+m.get(n).neighbours.size());
		}

	}

	
	static Map build_other_graph(Node node)
	{
		Map<Integer, Node> nodeMap = new HashMap();
		Set<Integer> visited = new HashSet();
		visited.add(node.val);
		dfs(nodeMap, node, visited);
		return nodeMap;
	}
	
	static void dfs(Map<Integer, Node> nodeMap, Node node, Set<Integer> visited) {
	    if(node != null) {
	        Node src = null;
	        Node dst = null;
	        if(!nodeMap.containsKey(node.val)) {
	            src = new Node(node.val);
	            nodeMap.put(node.val, src);
	        } else {
	            src = nodeMap.get(node.val);
	        }
	        for(Node neighNode: node.neighbours) {
	        	if(!visited.contains(neighNode.val)) {
	        		visited.add(neighNode.val);
	        		if(!nodeMap.containsKey(neighNode)) {
	        			dst = new Node(neighNode.val);
	        			nodeMap.put(neighNode.val, dst);
	        		} else {
	        			dst = nodeMap.get(neighNode.val);
	        		}

	        		dst.neighbours.add(src);
	        		dfs(nodeMap, neighNode, visited);
	        	} else {
	        		dst = nodeMap.get(neighNode.val);
	        		dst.neighbours.add(src);
	        	}
	            
	        }
	       
	        
	    }
	}
	
	static class Node
	{
		Integer val;
		Vector<Node> neighbours = new Vector<Node>(0);
		Node(Integer _val)
		{
			val = _val;
			neighbours.clear();
		}
	};

}
