/* Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.

 */

class Trie {

    /** Initialize your data structure here. */
    private Trie nodes[];
    private boolean isLast;

    public Trie() {
        this.nodes = new Trie[26];
        this.isLast = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie temp = this;
        for(char c: word.toCharArray()) {
            if((temp.nodes[c - 'a']) == null)
                temp.nodes[c - 'a'] = new Trie();
            temp = temp.nodes[c - 'a'];
        }
        temp.isLast = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp = this;
        for(char c: word.toCharArray()) {
            temp = temp.nodes[c - 'a'];
            if(temp == null)
                return false;
        }
        if(temp.isLast)
            return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(char c: prefix.toCharArray()) {
            temp = temp.nodes[c - 'a'];
            if(temp == null)
                return false;
        }
        return true;
    }
}

/*
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

