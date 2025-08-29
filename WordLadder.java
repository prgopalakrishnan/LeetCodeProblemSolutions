import java.util.*;


class WordLadder {
	
	
	public static void main(String[] args) {
		List<String> dict = new ArrayList();
		// "hit"
		//"cog"
		//["hot","dot","dog","lot","log","cog"]
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength("hit", "cog", dict));
	}
	
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<String>();
        return helper(beginWord, endWord, wordList, visited);
	}
    
  
  public int helper(String source, String target, List<String> wordList, Set<String> visited) {
    
    Queue<String> q = new LinkedList<String>();
    q.add(source);
    visited.add(source);
    
    int level = 0;
    while(q.size() > 0) {
      
      int size = q.size();
      for(int i =0; i < size; i++) {
            String s = q.poll();
            if(s.equals(target)) {
                return level;
            }
      
            List<String> oneEditWords = getOneEditWord(wordList, s);
            for(int j = 0; i < oneEditWords.size(); j++) {
                String curWord = oneEditWords.get(j);
                if(!visited.contains(curWord)) {
                    q.add(curWord);
                    visited.add(curWord);
                }
            }
      }
      level = level+1;
     }
    return -1;
  }
  
  
  
  // bit // but
  List<String> getOneEditWord(List<String> wordList, String source) {
    List<String> out = new ArrayList<String>();
        for(int i =0; i < wordList.size(); i++) {
            String s1 = wordList.get(i);
            int j = 0;
            int cnt = 0;
            while(j < s1.length()) {
                    if(s1.charAt(j) != source.charAt(j)) {
                        cnt = cnt + 1;
                    }
                    j++;
            }
            if(cnt == 1) {
                out.add(s1);
            }
        }
        return out;
  }

	


}