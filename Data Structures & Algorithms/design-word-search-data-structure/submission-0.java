class WordDictionary {

    // Definition of a Trie Node
    private static class TrieNode {
        private final TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            // 26 lowercase English letters ('a' through 'z')
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    
    /** Returns true if the word is in the data structure. A '.' can match any letter. */
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // Helper method to perform DFS for wildcard matching
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }

        // Base case: reached the end of the word
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard match: try all possible valid children
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchInNode(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            // Standard letter match
            int childIndex = ch - 'a';
            return searchInNode(word, index + 1, node.children[childIndex]);
        }
    }
}