//Objective is to see whether a starting word can reach an end word using a 'word ladder.'

let beginWord = "hit"
let endWord = "cog"
let wordList = ["hot","dot","dog","lot","log","cog"]


//O(M^2 * N) solution that uses BFS and a queue.

let dic = new Set(wordList)
let step = 1
let queue = [beginWord]
    
while (queue.length > 0) {
    let next = []
        
    for (let word of queue) {
        if (word == endWord) {
            return step
        }
         
        //Try to replace every single letter in the word with 
        //every single letter in the alphabet and add any words from the
        //dictionary into the next queue
        for (let i = 0; i < word.length; i++) {
            for (let j = 0; j < 26; j++) {
                let newWord = word.slice(0, i) + String.fromCharCode(97 + j) + word.slice(i + 1)
                    
                if (dic.has(newWord)) {
                    next.push(newWord)
                    dic.delete(newWord)
                }
            }
        }    
    }
    //Update the queue and increment the steps
    queue = next
    step++
}
    
return 0