class PrefixTree {

    TrieNode root = null;
    public PrefixTree() {
         root = new TrieNode('/', false);
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c-97;
            //System.out.println("c-97 = "+index);
            if(node != null && node.children[c-97] != null) {
                node = node.children[c-97];
                continue;
            } else {
                TrieNode newNode = new TrieNode(c, false);
                node.children[c-97] = newNode;
                node = node.children[c-97];
            }
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        if(word == null) {
            return false;
        }
        TrieNode node = root;
        boolean isWord = false;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c-97] == null) {
                return false;
            } else {
                node = node.children[c-97];
            }
        }
        return (node != null && node.isWord);
    }

    public boolean startsWith(String prefix) {
        if(prefix == null) {
            return false;
        }
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(node.children[c-97] == null) {
                return false;
            } else {
                node = node.children[c-97];
            }
        }
        return true;
    }





 class TrieNode {
    char c = 0;
    TrieNode[] children = null;
    boolean isWord = false;

    TrieNode(char c, boolean isWord) {
        this.c = c;
        this.isWord = isWord;
        children = new TrieNode[26];
    }
}
 
 public static void main(String args[]) {
		PrefixTree prefixTree = new PrefixTree();
		prefixTree.insert("dog");
		System.out.println(prefixTree.search("dog"));    // return true
		System.out.println(prefixTree.search("do"));     // return false
		System.out.println(prefixTree.startsWith("do")); // return true
		prefixTree.insert("do");
		System.out.println(prefixTree.search("do")); 
	}
}
