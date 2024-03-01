## Neetcode 150
### Arrays and Hashing
* LC 217 - Contains Duplicate
  * Create an hashset and put the elements
  * Return true if the element is in the hashset
* LC 242. Valid Anagram
  * Create an int array for 26 characters
  * for each element in either s or t , s-'a' ++ and then t-'a'--
  * loop through the array, if any element is non 0 then it is not anagram
* LC 1 - Two Sum
  * Create a Map of Int and Int
  * for each array elem, 
    * calculate the complement = target - arr[i]
    * if map contains the complement then return the current and map.get(complement)
    * else return new int[]{}
* LC 49. Group Anagrams
  * Create an Map<String, List<String>
  * convert the input to str.toCharArray()
  * sort the char array
  * convert the char array to new string
  * check if the new string is already there in the map and then add
  * return new ArrayList<Map.values()>
* LC 347. Top K Frequent Elements
  * Create a map of Int int
    * Create a freq map
  * Create a priority queue for a.getValue() - b.getValue() for the map entries
  * Add the map entries and remove from nimHeap if the size > K
  * Create an array list and push the elements into array list
  * res.stream().mapToInt(Integer::valueOf).toArray()
* LC 238. Product of Array Except Self
  * create left and right array
  * right[nums.lenth-1] = 1, left[0] = 1
  * result array = left[i] + right[i]
* LC 36. Valid Sudoku
  * Create a hashset
  * loop through all the cells
  * if the number is not '.'
    * then check for the below code
      * <code>if (!seen.add(number + " in row " + i) ||
        !seen.add(number + " in column " + j) ||
        !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
        return false;
        }</code>
* LC 128. Longest Consecutive Sequence
  * Create a visited map
  * loop through the numbers (check for the key and the visited false)
  * add length++
  * check fot he previous numbers and increase the length++
  * each iteration get the longestpath and reset the current path variable

<hr />
### Two Pointers

* LC 125. Valid Palindrome
  * p1 = 0, p2 = len-1
  * while(p1 <= p2)
    * if charatp1 Charcter.isLetterOrDigit() == false
      * p1++
    * similarly for p2--
    * else if they are not the same character then return false
      * else p1++ and p2--
    * return true
* LC 167. Two Sum II - Input Array Is Sorted
  * p1 = 0, p2 = leng-1
  * while(p1 < p2)
  * calcualte p1+p2
    * if sum > target then p2--
    * < target then p1++
    * else return the array {p1+1, p2+1}
* LC 15. 3Sum (Sum to 0 - Need to find all the triplets)
  * Create a hashset
  * Sort the intput array -> O(nlogn)
  * for each element
    * left = i+1
    * right = len-1
    * check if(i+left+right == 0) add the combo to the Hashset
    * if sum < 0  then left++
    * if sum> 0 then right--
* LC 11. Container With Most Water
  * Create left=0, right=leng-1, minHeight, maxWater = 0
  * while(left < right)
    * get the min(height[left], height[right])
    * maxWater = Max(maxWater, minHeight*(right-left))
    * while(heigh[left]<=minHeight && left < right) left++;
    * similarly for while(heigh[right]<=minHeight && left < right) right--;
  * return maxWater
* LC 42. Trapping Rain Water:
  * lft, right, waterContent, maxLeft, maxRight
  * THis problem has 4 comparisons
  * while(left <= right)
    * if(height[left] <= height[ritgh])
      * then check height[left] > maxLeft
        * then maxLeft = height[left]
        * else watercontent += maxLeft - height[left]
        * left++
    * else part for the right variable
      * then right--

<hr />
### Sliding Window

* LC 121. Best Time to Buy and Sell Stock
  * buystock=intmin
  * maxprofit=0
  * loop through the proces
  * if(buystock < current proce) 
    * then calculate the currprofit
    * maxprofit = max(maxroft, currprofit)
  * else 
    * buystock = current price as the current price is the minimum
  * return the max profit

* LC 3. Longest Substring Without Repeating Characters
  * Create a HashMap<Char, Integer> freq Map
  * left=0, right=0
  * loop through the characters
    * if the char is not in the map
      * add the char with current position as the right
    * else
      * calculate the left as map.get(ch)+1 for the next loop
      * right will be the current position 
    * length=max(length, (right-left)+1)
* LC 424. Longest Repeating Character Replacement
  * problem is ABAA -> AAAA with the K replacement
  * create a freq int array
  * maxLength=0
  * maxF=0 for interim calculation
  * left, right=0.
  * right will go into the loo
  * for each character
    * maxF = math(maxF, ++freq[rightchar-'A])
    * check if the replacement exceeds K
    * if(right-left+1-maxF > K) reduce the freq with left char 
      * set left++
    * maxLen = max(maxLen, right-left+1)
* LC 567. Permutation in String
  * check if s1 contains permutation of s2 as substring
  * create a freq count array
  * for first window
    * char-++ for s1
    * char--- for s2
    * check if all 0 then true
  * else from the second window
    * char(i) -- for s1
    * char(i-len1) ++ for s1 again (adding the current window character)
    * check if all 0 then true
  * Chcking 0 code
    * <code>for (int i = 0; i < 26; i++) {
      if (count[i] != 0) return false;
      }
      return true;</code>
* LC 76. Minimum Window Substring
  * create a freq map for the string t
    * Map<Charactger, Int>
    * for t add the freq to the map
    * i-,j,min=s.length()
    * left0, right=s.len-1, found=false
    * while(j <s.length()) {
    * j will be moving to the right
    * if map contains the char
      * then redude the count in the char
      * if the count for the char become 0 then redude the main count -1
    * continue until count >0
    * if it is less than count the 1 substring found
    * while count =0 move the i++ 
      * when anychar again > 0 in the map then increase count
    * min = i-j for the current iteration 
  * finally return (!found) ? "" : s.substring(left-1, right);

* LC 239. Sliding Window Maximum
  * create a result array rs = new int[n-k+1]
  * int ri = 0
  * create a queue using ArrayDeque
  * loop through the array from start to end
    * remove the element in the front if the peek index is i-k
    * remove all the elements that are < a[i] then front will have the greatest element in the current window
    * Update the rs[ri++] as arr[q.peek()]

<hr />
### Stack

* LC 20 Valid Parantheses
  * Create a character Stack
  * char c: str.toCharArray()
  * if '(' then push ')'
  * if closing then check if the characters are matching else return false
  * fianlly return stack.isEmpty()

* LC 155 - MinStack
  * Create a Long Stack, Long Min
  * mini = Long.MAX_VALUE
  * getMin - return mini
  * top - 
    * get the peak
    * if peek < mini then return mini.intValue else peek.intValue
  * push
    * if empty then push, mini=x
    * if x > mini  then oush
    * if x < mini then push(2*x - mini) then mini=val
  * pop
    * if empty then return
      * if top < min then current min=2*min-val
* LC 150 - Evaluate Reverse Polish Notation
  * <code>Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9 </code>
  * Create a Integer Stack
  * int a, b
  * for each string in source
    * if "+" then stack.push(stack.pop()+stack.pop())
    * same for "*"
    * For division it will be b-a
    * For sub it will be b-a
    * else push Integer.parseInt(s)
    * return stack.pop()
* LC 22 - Generate Parantheses
  * <code>Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"] </code>
  * Create a integer list <String> 
  * start recursion generate(list, int open, int close, n, int str)
    * // base case
    * if the str.length = 2*n then add to the result and return
    * if(open < n) then open+1, str+"C"
    * if(close<open) then close+1 , str+")"
* LC 739 - Daily Temperatures
  * Createa an integer stack
  * create a result array
  * loop through each element
    * while(stack is not empoty and currtent element > temp[stack.peek()])
      * idx = i - stack[top]
      * result[idx] = i-idx
      * stack.push(i)