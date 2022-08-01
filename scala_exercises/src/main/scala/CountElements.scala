object CountElements extends App {
    def countInts(v: Int, input: List[Int]): Int = {
        input.fold(0)((x, y) => {
            if (y == v) {
                x + 1
            } else {
                x
            }
        })
    }

    def countGeneric[A](v: A, input: List[A]): Int = {
        input.foldLeft(0)((x, y) => {
            if (y == v) {
                x + 1
            } else {
                x
            }
        })
    }

    println(countInts(2, List(1, 2, 1, 1, 1, 2, 4, 2, 2, 2, 2)))
    println(countGeneric('a', List(1, 'a', 'a', 2, 'b')))
}

