object ReplicateElements extends App {
    def replicate[A](copies: Int, lst: List[A]): List[A] = {
        lst.flatMap(e => List.fill(copies)(e))
    }
}
