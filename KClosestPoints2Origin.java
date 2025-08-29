
import java.util.*;

public class KClosestPoints2Origin {
	public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<double[]>(k, new DistanceComparator());

        for(int i =0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double dist = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));

            if(maxHeap.size() < k) {
                maxHeap.add(new double[]{dist, i});
            } else {
                double curDist = maxHeap.peek()[0];
                if(curDist > dist) {
                    maxHeap.poll();
                    maxHeap.add(new double[]{dist, i});
                }
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(maxHeap.size() > 0) {
            result[i++] = points[(int)maxHeap.poll()[1]];
        }

        return result;
    }

   
	    
	    public static void main(String[] args) {
	    	KClosestPoints2Origin obj = new KClosestPoints2Origin();
	    	int[][] points = new int[][] { {-5,4},{-6,-5},{4,6}};
	    			
	    								
	    	int[][]  results = obj.kClosest(points, 2);
	    	for(int i =0; i < results.length; i++) {
	    		System.out.println(results[i][0]+" "+results[i][1]);
	    	}
	    }

	    
}

 class DistanceComparator implements Comparator<double[]> {
    public int compare(double[] a, double[] b) {
        return Double.compare(b[0], a[0]);
    }
}

	    


