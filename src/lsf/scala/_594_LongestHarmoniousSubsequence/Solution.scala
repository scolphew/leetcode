object Solution {
  def findLHS(nums: Array[Int]): Int = {
    var map: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map()
    for (num <- nums) {
      map += (num -> (map.getOrElse(num, 0) + 1))
    }
    var result = 0

    for (key <- map.keySet) {
      if (map.contains(key + 1)) {
        result = math.max(result, map(key) + map(key + 1))
      }
    }
    return result
  }

  def main(args: Array[String]): Unit = {
    println(findLHS(Array(1, 2, 3, 3)))
  }
}