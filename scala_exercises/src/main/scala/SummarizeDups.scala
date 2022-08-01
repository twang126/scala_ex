import scala.annotation.tailrec

// Given a list of ['a', 'a', 'b', 'c'], return => [['a', 'a', 'a'], ['b'], ['c']]
object SummarizeDups extends App {
  def summarize[A](l: List[A]): List[List[A]] = {
    @tailrec
    def _pack(result: List[List[A]], input_list: List[A]): List[List[A]] = {
        input_list match {
            case Nil => result
            case _ => {
                val (s: List[A], r: List[A]) = input_list.span(a => a == input_list.head)
                _pack(result:::List(s), r)
            }
        }
    }

    _pack(List.empty, l)
  }
}
