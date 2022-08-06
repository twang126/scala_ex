package hands_on_scala

class TrieMapTest extends munit.FunSuite {
    test("TrieMap.remove") {
        val map = hands_on_scala.chapter6.TrieMap[Int]()

        map.add("te", 10)
        map.remove("te")

        map.add("ba", 1)
        map.add("bd", 2)
        map.remove("bd")

        var curr = Option(map.root)

        for  (c <- curr.get.children.keys) {
            println(c)
        }
    }
}