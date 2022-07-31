object FindKth extends App {
  def findKth[A](k: Int, input: List[A]): Option[A] = {
    (k, input) match {
        case (1, h::_) => Some(h)
        case (k, _::tail) => findKth(k-1, tail)
        case _ => None
    }
  }

  // First element
  println(findKth(1, List(1, 2, 3, 4, 5, 6)))

  // 3rd element
  println(findKth(3, List(1, 2, 3, 4, 5, 6)))

  // Last element
  println(findKth(6, List(1, 2, 3, 4, 5, 6)))

  // Out of bounds
  println(findKth(10, List(1, 2, 3, 4, 5, 6)))
}