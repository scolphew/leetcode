package lsf.kotlin


fun reverseStr(s: String, k: Int): String {
    val chars = s.toCharArray()
    for (i in 0..chars.size step k * 2) {
        reverseStr(chars, i, k)
    }
    return String(chars)

}

fun reverseStr(chars: CharArray, begin: Int, len: Int) {
    var left = begin
    var right = minOf(begin + len - 1, chars.size - 1)
    while (left < right) {
        val tmp = chars[left]
        chars[left] = chars[right]
        chars[right] = tmp
        left++
        right--
    }
}


fun main(args: Array<String>) {
    println(reverseStr("abcdefg", 2))
}