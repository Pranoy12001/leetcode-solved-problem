class Trie {
    private Node root;
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Node(ch);
            }
            
            cur = cur.children[ch - 'a'];
        }
        
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = getNode(word);
        
        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    private Node getNode(String word) {
        Node cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                return null;
            }
            
            cur = cur.children[ch - 'a'];
        }
        
        return cur;
    }
    
    class Node {
        public char ch;
        
        public boolean isWord;
        
        Node[] children;
        
        public Node(char ch) {
            this.ch = ch;
            this.isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */