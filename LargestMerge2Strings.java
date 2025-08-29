

public class LargestMerge2Strings {
	
		public static void main(String args[]) {
			LargestMerge2Strings ls = new LargestMerge2Strings();
			//"cabaa"
			//"bcaaa"
			
			//Input
//			"qqqqqqqqqeqeqqeeqqq"
//			"qqqqqqqqeqqqeeqqeeqqqqqeq"
			String result = ls.largestMerge("qqqqqqqqqeqeqqeeqqq", "qqqqqqqqeqqqeeqqeeqqqqqeq");
			System.out.print(result);
		}
	
	    public String largestMerge(String word1, String word2) {
	        
	        if(word2 == null) {
	            return word1;
	        }
	        
	        if(word1 == null) {
	            return word2;
	        }
	        
	         int m = word1.length(); int n = word2.length();
	            int i = 0;
	            int j = 0;
	            int k = 0;
	            StringBuffer merge = new StringBuffer();
	                    int cnt = 0;
	                    int tmpI = i;
	                    int tmpJ = j;
	 
	        if(word1 != null && word2 != null && word1.length() > 0 && word2.length() > 0) {
	                      while (i < m && j < n) {
	                char c1 = word1.charAt(i);
	                char c2 = word2.charAt(j);
	                
	                if(merge.toString().equals("qqqqqqqqq")) {
	                	System.out.print("stop");
	                }
	                
	                if(c1 > c2) {
	                    merge.append(c1);
	                    i++;
	                } else if (c2 > c1) {
	                    merge.append(c2);
	                    j++;
	                } else {
	                     cnt = 0;
	                     tmpI = i;
	                     tmpJ = j;
	                    while(tmpI< m && tmpJ < n && word1.charAt(tmpI) == word2.charAt(tmpJ)) {
	                        tmpI++;
	                        tmpJ++;
	                        cnt++;
	                    }
	                    
	                    if(tmpI < m && tmpJ < n) {
	                        String copyStr = word1;
	                        int copyIdx = i;
	                        i = i+cnt;
	                        if(word2.charAt(tmpJ) > word1.charAt(tmpI)){
	                            copyStr = word2;
	                            copyIdx = j;
	                            j = j+cnt;
	                            i = i-cnt;
	                        }
	                        for(int a = copyIdx; a < copyIdx+cnt; a++) {
	                            merge.append(copyStr.charAt(a));
	                        }
	                    } else if(tmpI >= m && tmpJ >= n) {
	                    	merge.append(word1.charAt(i));
	                    	i++;
	                    } else if(tmpI >= m && tmpJ < n ) {

	                    	for(int a = i; a < m; a++) {
	                            merge.append(word1.charAt(a));
	                        }
	                        i = i+cnt;
	                    } else if(tmpJ >= n && tmpI < m ) {

	                        for(int a = j; a < n; a++) {
	                            merge.append(word2.charAt(a));
	                        }
	                        j = j+cnt;
	                    } 
	                }
	            } 
	        }
	        
	        if(i < m) {
	            for(int a = i; a < m; a++) {
	                merge.append(word1.charAt(a));
	            }
	        }
	        if(j < n) {
	            for(int a = j; a < n; a++) {
	                merge.append(word2.charAt(a));
	            }
	        }
	        
	        return merge.toString();
	        
	    }
	

}
