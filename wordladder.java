//Java Solution

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        
        while (!queue.isEmpty()) {
            Queue<String> next = new LinkedList<>();
            int size = queue.size();
            
            while (size > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return steps;
                }
                
                for (int i = 0; i < curr.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newWord = curr.substring(0, i) + c + curr.substring(i + 1);
                        
                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            next.add(newWord);
                        }
                    }
                }
                
                size--;
            }
            
            queue = next;
            steps++;
        }
        
        return 0;
    }
}