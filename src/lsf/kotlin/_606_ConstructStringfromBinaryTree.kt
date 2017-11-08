package lsf.kotlin

import base.TreeNode

fun tree2str(t: TreeNode?): String {
    if (t == null) return ""

    val result = t.`val`.toString()

    val left = tree2str(t.left)
    val right = tree2str(t.right)

    if (left === "" && right === "") return result
    if (left === "") return "$result()($right)"
    return if (right === "") "$result($left)" else "$result($left)($right)"
}

fun main(args: Array<String>) {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    print(tree2str(root))
}