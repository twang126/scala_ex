object ListLength extends App {
    def getListLength[A](v: List[A]): Int = {
        def findLength[A](n: Int, l: List[A]): Int = {
            l match {
                case h::t => findLength(n + 1, t)
                case _ => n
            }
        }

        findLength(0, v)
    }

    def lengthFold[A](v: List[A]): Int = {
        v.foldLeft(0)((a, v) => a + 1)
    }
}
