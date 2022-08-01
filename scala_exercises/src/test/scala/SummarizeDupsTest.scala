class SummarizeDupsTest extends munit.FunSuite{
    test("SummarizeDups._pack") {
        assert(
            SummarizeDups.summarize(List(1, 1, 2, 2, 3, 4, 2, 2, 2)) == List(List(1, 1), List(2, 2), List(3), List(4), List(2, 2, 2))
        )
    }
  
}
