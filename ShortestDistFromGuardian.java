
import java.util.*;

public class ShortestDistFromGuardian {


	public static void main(String args[]) {
		List l1 = new ArrayList();
		l1.add('O');l1.add('O');l1.add('O');l1.add('O');l1.add('G');
		List l2 = new ArrayList();
		l2.add('O');l2.add('W');l2.add('W');l2.add('O');l2.add('O');
		List l3 = new ArrayList();
		l3.add('O');l3.add('O');l3.add('O');l3.add('W');l3.add('O');
		List l4 = new ArrayList();
		l4.add('G');l4.add('W');l4.add('W');l4.add('W');l4.add('O');
		List l5 = new ArrayList();
		l5.add('O');l5.add('O');l5.add('O');l5.add('O');l5.add('G');

		List in  = new ArrayList();
		in.add(l1);in.add(l2); in.add(l3); in.add(l4); in.add(l5); 

		System.out.println(find_shortest_distance_from_a_guard(in));


	}

	public static List<List<Integer>> find_shortest_distance_from_a_guard(List<List<Character>> grid) {
		// Write your code here
		List<List<Integer>> output = new ArrayList();

		int[][] dir = { {0, -1}, {0,1}, {-1, 0}, {1,0}};

		if(grid != null && grid.size() > 0) {
			int n = grid.size();
			int m = grid.get(0).size();

			for(int i = 0; i < n; i++) {
				List l = new ArrayList();
				for(int j =0; j < m; j++) {
					l.add(-1);
				}
				output.add(l);
			}

			for(int i = 0; i < n; i++) {
				for(int j =0; j < m; j++) {
					if(grid.get(i).get(j) == 'G') {
						output.get(i).set(j, 0);
						boolean[][] visited = new boolean[n][m];
						visited[i][j] = true;
						bfs(visited, output, grid, i, j, dir, n, m);
					}
				}
			}
		}
		return output;
	}

	static void bfs(boolean[][] visited, List<List<Integer>> output, List<List<Character>> grid, int i, int j, int[][] dir, int n, int m) {
		Queue<int[]> q = new LinkedList();
		q.add(new int[] {i, j});

		visited[i][j] = true;

		int cnt = q.size();
		int level = 1;
		while(q.size() > 0) {
			int[] curPoint = q.remove();
			cnt--;

			for(int[] curDir: dir) {
				int neigh_x = curPoint[0]+curDir[0];
				int neigh_y = curPoint[1]+curDir[1];

				if(neigh_x >=0 && neigh_x < n && neigh_y >=0 && neigh_y < m) {
					if(!visited[neigh_x][neigh_y]) {
						visited[neigh_x][neigh_y] = true;
						if(grid.get(neigh_x).get(neigh_y) == 'O') {
							if(output.get(neigh_x).get(neigh_y) == -1 || level < output.get(neigh_x).get(neigh_y)) {
								output.get(neigh_x).set(neigh_y, level);
							} 
							q.add(new int[]{neigh_x, neigh_y});
						}
					}
				}
			}
			if(cnt == 0) {
				cnt = q.size();
				level++;
			}
		}
		
	}



}
