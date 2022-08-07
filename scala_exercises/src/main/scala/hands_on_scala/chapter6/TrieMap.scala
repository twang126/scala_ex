package hands_on_scala.chapter6

import scala.collection.mutable
import scala.reflect.ClassTag

class TrieMap[T] {
  class Node(var value: Option[T], val children: scala.collection.mutable.Map[Char, Node] = collection.mutable.Map()) {}
  val root: Node = Node(None)

  def add(str: String, value: T): Unit = {
    var current = root;
    for (c <- str) current = current.children.getOrElseUpdate(c, new Node( None))

    current.value = Some(value)
  }

  def get(str: String): Option[T] = {
    var current = Option(root);
    for (c <- str if current.nonEmpty) current = current.get.children.get(c)

    current.flatMap(_.value)
  }

  def contains(str: String): Boolean = {
    get(str).nonEmpty
  }

  def remove(str: String): Boolean = {
    if (!contains(str)) {
      false
    } else {
      _delete(str.substring(1), root.children.get(str(0)), Option(root), str(0))
      true
    }
  }

  private def _delete(str: String, curr: Option[Node], prev: Option[Node], c: Char): Boolean = {
    if (str.isEmpty) {
      curr.get.value = None
      if (curr.get.children.isEmpty) {
        prev.map(_.children.remove(c))
        true
      } else {
        false
      }
    } else {
      val can_delete = _delete(str.substring(1), curr.get.children.get(str(0)), curr, str(0))

      if (can_delete && curr.get.children.isEmpty) {
        prev.map(_.children.remove(c))
        true
      } else {
        false
      }
    }
  }

  def getValuesWithMatchingPrefixes(s: String)(implicit t: ClassTag[T]): Array[T] = {
    var curr = Option(root)

    for (c <- s if curr.nonEmpty) curr = curr.get.children.get(c)

    if (curr.isEmpty) {
      Array()
    } else {
      val results: mutable.ArrayBuilder[T] = Array.newBuilder[T]

      def recurse(curr: Node): Unit = {
        if (curr.value.nonEmpty) {
          results.addOne(curr.value.get)
        }

        for ((c, n) <- curr.children) {
          recurse(n)
        }
      }

      recurse(curr.get)
      results.result()
    }
  }
}
