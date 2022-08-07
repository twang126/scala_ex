package hands_on_scala

class TrieMapTest extends munit.FunSuite {
    test("TrieMap.remove") {
        val map = hands_on_scala.chapter6.TrieMap[Int]()

        map.add("te", 10)
        map.remove("te")

        map.add("ba", 1)
        map.add("bd", 2)
        map.remove("bd")
        map.remove("ba")

        var curr = Option(map.root)

        for  (c <- curr.get.children.keys) {
            println(c)
        }

        map.add("a", 2)
        map.add("abcd", 3)
        map.add("b", 30)
        map.add("ace", 4)

        map.getValuesWithMatchingPrefixes("a").foreach(println)

    }
}