Question-


Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')



Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.


 

Solution-


class Solution {
    public int minDistance(String word1, String word2) {
        char[] str1=word1.toCharArray();
        char[] str2=word2.toCharArray();
        int temp[][]=new int[str1.length+1][str2.length+1];
        for(int i=0;i<temp[0].length;i++){
            temp[0][i]=i;
        }
        for(int i=0;i<temp.length;i++){
            temp[i][0]=i;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){
                if(str1[i-1]==str2[j-1]){
                    temp[i][j]=temp[i-1][j-1];
                }
                else{
                    temp[i][j]=1+Math.min(Math.min(temp[i-1][j-1],temp[i-1][j]),temp[i][j-1]);
                }
            }
        }
        return temp[str1.length][str2.length];

    }
}
