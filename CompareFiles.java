

import java.io.*;
import java.util.*;


/**
 * We have two large files, each containing millions
 *  of user IDs — one per line. They don’t fit in memory completely.
Goal:
 Write a Java program to produce an output file C
  that contains only user IDs that are Present in A and Not present in B
 * @author priyagopalakrishnan
 * 
 * code ,resume, availabitlty dates
niveditha@refnet.ai
 * 
 * 
 * File A -> 3,1,9
 * File B -> 2, 0, 10
 * 
 * 1. Sort File A -- 1,3,9
 * 2. Sort B -> 0,2,10
 * 
 * 9 --- 1
 * 
 * C - 1, 3, 9, 
 * 
 * 10,0000 1000 Write to file 1 1000
 * 1000
 * 1000
 * 
 * Sort 
 *
 */
public class CompareFiles {
	
	public void compare(String fileNameA, String fileNameB) {
		
		// Sort File A and File B
		
		/**
		 * 
		 * 
		 * */
		
		
		
		
		List<String> fileA = getLines(fileNameA, 0);
		List<String> fileB = getLines(fileNameA, 0);
		List<String> fileC = new ArrayList();
		findDiff(fileA, fileB, fileC);
	}
	
	
	/**
	 * 3 2
	 * @param fileA
	 * @param fileB
	 * @param fileC
	 */
	public void findDiff(List<String> fileA, List<String> fileB , List<String> fileC ) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < fileA.size() && j < fileB.size()) {
			if(fileA.get(i) > fileB.get(j)) {
				j++;
				continue;
			} else if(i < fileA.size() == j < fileB.size()) {
				i++; j++; continue;
			} else {
				
			}
		}
	}
	
	public List<String> getLines(String filename, int offset) {
		List<String> list = new ArrayList<String>();

		try {
		BufferedReader bufInput = new BufferedReader(new FileReader(filename));
		String line = bufInput.readLine();
		int count = 500;
		
		for(int i = offset; i < offset+count; i++) {
			line = bufInput.readLine();
			list.add(line);
		}
		} catch(Exception e) {
			
		}
		
		return list;
	}
	
	
	public static void main(String args[]) {
		
	}

}
