object RunLengthEncoding extends App {
  def runLengthEncoding[A](lst: List[A]): List[(Int, A)] = {
    def _encoding(res: List[(Int, A)], curr: List[A]): List[(Int, A)] = {
        curr match {
            case Nil => res
            case h::t => {
                var (s, e) = t.span(a => a == h)
                _encoding(res:+(s.length + 1, h), e)
            }
        }
    }

    _encoding(List.empty, lst)
  }

  println(runLengthEncoding(List('a', 'a', 'a', 'b', 'c')))
  println(runLengthEncoding(List()))
}
