package train;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 */
public class LongestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {

        if(text1 == null || text1.length() == 0
                || text2 == null || text2.length() == 0){
            return 0;
        }

        char[] char1 = text1.toCharArray();
        int length1 = char1.length;
        char[] char2 = text2.toCharArray();
        int length2 = char2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(char1[i - 1] == char2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[length1][length2];
    }
}
