package com.jhjz.emr.uirepo

import org.junit.Test
import java.util.*

/**
 * @describe :
 *
 * @author zwq 2020/9/3
 */
class StringAlgo {

    @Test
    fun run() {

    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    示例 1:
    输入: ["flower","flow","flight"]
    输出: "fl"
     *
     * 取第一个String为默认值 依次判断判断后续String与默认str前几位相同
     * 截取相同继续向后判断 如果为空提前结束
     * 时间复杂度O(n) n为所有字符串长度 空间复杂度O()
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var result = strs[0]
        for (i in 1 until strs.size) {
            var j = 0
            while (j < result.length && j < strs[i].length) {
                if (result[j] != strs[i][j]) break
                j++
            }
            result = result.substring(0, j)
            if (result.isEmpty()) return ""
        }
        return result
    }


    /**
     * 外观数列
     * 例子：
     * 1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
     */
    fun countAndSay(n: Int): String {
        //记录结果 初始值为1
        var result = "1"
        //从第二位到n 循环 除去默认值
        for (i in 2..n) {
            //拼接数据
            val builder = StringBuilder()

            var pre = result[0]

            var count = 1
            for (j in 1 until result.length) {
                //获取下一位 用来比较
                var next = result[j]
                //相同代表这个数字出现过两次 做记录
                if (pre == next) {
                    count++
                } else {

                    builder.append(count).append(pre)
                    count = 1
                    pre = next
                }
            }
            //次数+值
            builder.append(count).append(pre)
            result = builder.toString()
        }

        return result
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
    你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

    示例 1：

    输入：["h","e","l","l","o"]
    输出：["o","l","l","e","h"]
    示例 2：

    输入：["H","a","n","n","a","h"]
    输出：["h","a","n","n","a","H"]

    利用双指针 替换左一位 和 右一位
     */
    fun reverseString(charArray: CharArray): CharArray {
        var start = 0
        var end = charArray.size - 1
        var temp: Char
        while (start < end) {
            temp = charArray[start]
            charArray[start++] = charArray[end]
            charArray[end--] = temp
        }
        return charArray
    }

    /**
     *
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：本题中，我们将空字符串定义为有效的回文串。

    示例 1:
    输入: "A man, a plan, a canal: Panama"
    输出: true

    示例 2:
    输入: "race a car"
    输出: false

    1.筛选 把字符串中的数字和字符取出
    2.双指针判断 是否 相同
    O(n)
    O(n)
     */
    fun isPalindrome(s: String): Boolean {
        val strBuf = StringBuffer()
        for (i in s.indices) {
            val ch = s[i]
            if (Character.isLetterOrDigit(ch)) {
                strBuf.append(ch)
            }
        }

        var start = 0
        var end = strBuf.length - 1
        while (start < end) {
            if (Character.toLowerCase(strBuf[start++]) != Character.toLowerCase(strBuf[end--])) {
                return false
            }
        }
        return true
    }

    /**
     * 有效的字母异位词
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true

    示例 2:
    输入: s = "rat", t = "car"
    输出: false
    说明:
    你可以假设字符串只包含小写字母。

    进阶:
    如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    fun isAnagram(s: String, t: String): Boolean = s.sortStr() == t.sortStr()

    /**
     * O(nlogn)
     */
    private fun String.sortStr(): String {
        val toCharArray = this.toCharArray()
        Arrays.sort(toCharArray)
        return toCharArray.contentToString()
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * map记录charAt,number
     * get number
     */
    fun firstUnitChar(str: String): Int {
        val map = mutableMapOf<Char, Int>()
        val n = str.length
        for (i in 0 until n) {
            map[str[i]] = map.getOrDefault(str[i], 0) + 1
        }

        for (i in 0 until n) {
            if (map[str[i]] == 1) {
                return i
            }
        }
        return -1
    }


}