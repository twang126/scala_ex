package hands_on_scala.chapter6

class ImmutableTrie(words: List[String]) extends App {
  class Node(val index: Int, val wordsList: List[String]) {
    val hasValue: Boolean = wordsList.exists(w => w.length == index)
    val children: Map[Char, Node] = {
      val filteredInputs = wordsList.filter(w => w.length > index)

      for (
        (child, childWords) <- wordsList.groupBy(w => w.charAt(index))
      ) yield (child, new Node(index + 1, childWords))
    }
  }

  val root = Node(0, words)

  def contains(s: String): Boolean = {
    var r = Option(root)

    for (c <- s if r.nonEmpty) {
      r = r.get.children.get(c)
    }

    r.exists(_.hasValue)
  }

  def matchedStrings(s: String): Set[String] = {
    var r = Option(root)

    for (c <- s if r.nonEmpty) r = r.get.children.get(c)

    if (r.isEmpty) {
      Set()
    } else {
      val output = Set.newBuilder[String]
      def recurse(curr: Node, path: List[Char]): Unit = {
        if (curr.hasValue) {
          output.addOne(s + path.reverse.toString())
          for ( (c, n) <- curr.children ) {
            recurse(n, c :: path)
          }
        }
      }

      recurse(r.get, List.empty)
      output.result()
    }
  }

}
