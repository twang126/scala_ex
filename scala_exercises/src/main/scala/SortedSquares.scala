object SortedSquares extends App {
    def sortedSquares(nums: Array[Int]): Array[Int] = {
        def inner(nums: Array[Int], output: List[Int]): Array[Int] = {
            (nums.headOption.map(v => v * v), nums.lastOption.map(v => v * v)) match {
                case (Some(h), Some(t)) => if (h < t) then inner(nums.init, t :: output) else inner(nums.tail, h :: output)
                case (Some(h), None) => inner(nums.init, h :: output).toArray
                case _ => output.toArray
            }
        }

        inner(nums, List.empty)
    }

    for (v <- sortedSquares(Array(-4,-1,0,3,10))) println(v)
    println("--------")
    for (v <- sortedSquares(Array(1, 2, 3, 4, 5))) println(v)
}
