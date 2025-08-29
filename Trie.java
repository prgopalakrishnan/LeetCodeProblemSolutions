class Trie {
    
    char c = '\0';
    Trie children[] = null;
    boolean isWord = false;
    
    public Trie root = null;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        for(int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
    
    public void setChar(char c) {
        this.c = c;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word != null && word.length() > 0) {
            if(root == null) {
                root = new Trie();
            }
            
            insertHelper(word, 0);
        }
    }
    
    public void insertHelper(String word, int i) {
        Trie cur = root;
        Trie node = null;
        for(int k = i;  k < word.length(); k++) {
            char t = word.charAt(k);
            int idx = (int)t - 97;
            if(cur.children != null && cur.children[idx] == null) {
                node = new Trie();
                node.setChar(t);
                cur.children[(int)t - 97] = node;
            } 
            cur = cur.children[(int)t - 97];
            if(k == word.length()-1) {
                cur.isWord = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(root == null) {
            return false;
        }
        int i = 0;
        Trie cur = root;
        while (i < word.length()) {
           
            char t = word.charAt(i);
            if(cur.children[(int)t - 97] != null) {
                cur = cur.children[(int)t - 97] ;
                if( i == word.length()-1 && cur.isWord) {
                    return true;
                }
                i++;
            } else {
                break;
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         if(root == null) {
            return false;
        }
        int i = 0;
        Trie cur = root;
        while (i < prefix.length()) {
           
            char t = prefix.charAt(i);
            if(cur.children[(int)t - 97] != null) {
                cur = cur.children[(int)t - 97] ;
                if( i == prefix.length()-1 && cur != null) {
                    return true;
                }
                i++;
            } else {
                break;
            }
        }
        return false;
    }
    
    public static void print(Trie node) {
    	if(node != null && node.children != null) {
    		for(int i =0; i < 26; i++) {
    			if(node.children[i] != null) {
    				System.out.println(node.children[i].c);
    				print(node.children[i]);
    			}
    		}
    	}
    }
    
    
    public static void main(String args[]) {
    	Trie trie = new Trie();
    	trie.insert("hello");
    	//print(trie.root);
//    	System.out.println(trie.search("apple"));   // return True
//    	System.out.println(trie.search("app"));     // return False
    	System.out.println(trie.startsWith("helloa")); // return True
//    	trie.insert("app");
//    	System.out.println(trie.search("app"));// true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */