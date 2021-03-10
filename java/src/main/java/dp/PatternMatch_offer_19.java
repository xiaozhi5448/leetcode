package dp;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class PatternMatch_offer_19 {
    private boolean match(String s, String p, int sIndex, int pIndex) {
        if (sIndex < 0 || pIndex < 0) {
            return false;
        } else if (p.charAt(pIndex) == '.') {
            return true;
        } else {
            return p.charAt(pIndex) == s.charAt(sIndex);
        }
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] matchFlags = new boolean[sLen + 1][pLen + 1];
        matchFlags[0][0] = true;
        for (int sIndex = 0; sIndex <= sLen; sIndex++) {
            for (int pIndex = 1; pIndex <= pLen; pIndex++) {
                if (p.charAt(pIndex - 1) != '*') {
                    if (sIndex == 0) {
                        matchFlags[sIndex][pIndex] = false;
                        continue;
                    }
                    if (match(s, p, sIndex-1, pIndex - 1)) {
                        matchFlags[sIndex][pIndex] = matchFlags[sIndex - 1][pIndex - 1];
                    }
                } else {
                    // 丢弃当前 c*组合
                    matchFlags[sIndex][pIndex] = matchFlags[sIndex][pIndex - 2];
                    // 丢弃s中当前字符
                    if (match(s, p, sIndex-1, pIndex - 2)) {
                        matchFlags[sIndex][pIndex] |= matchFlags[sIndex - 1][pIndex];
                    }
                }
            }
        }
        return matchFlags[sLen][pLen];
    }
}
