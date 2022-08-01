class CountElementsTest extends munit.FunSuite {
    test("CountElements.countGeneric") {
        assert(CountElements.countGeneric(1, List(1, 2, 3)) == 1)
    }

    test("CountElements.countInts") {
        assert(CountElements.countInts(1, List(1, 2, 3, 1, 1, 1, 2, 4, 1)) == 5)
    }

    test("CountElements.countStringsNoMatch") {
        assert(CountElements.countGeneric(1, List("a", "b", 3)) == 0)
    }

    test("CountElements.countStrings") {
        assert(CountElements.countGeneric("a", List("a", "b", 3)) == 1)
    }
}