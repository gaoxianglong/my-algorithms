package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 相同字符
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/25 09:53
 */
public class SameChar {
    public String deduplicate(String str) {
        if (str.isBlank()) {
            return null;
        }
        var builder = new StringBuilder();
        var strArray = str.toCharArray();
        char prev = strArray[0];
        builder.append(prev);
        for (var i = 1; i < strArray.length; i++) {
            if (prev != strArray[i]) {
                builder.append(strArray[i]);
                prev = strArray[i];
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        var sameChar = new SameChar();
        Assert.assertEquals("abcd", sameChar.deduplicate("abbbbbcccdd"));
        Assert.assertEquals(null, sameChar.deduplicate(""));
        Assert.assertEquals("abcd", sameChar.deduplicate("abcd"));
        Assert.assertEquals("abcabc", sameChar.deduplicate("aabbccaabbcc"));
        Assert.assertEquals("dog -ds", sameChar.deduplicate("dog   -ds"));
    }
}
