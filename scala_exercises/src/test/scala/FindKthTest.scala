class FindKthTest extends munit.FunSuite  {
  test("FindKth.findFirst") {
    assert(FindKth.findKth(1, List(1, 2, 3)) == Some(1))
  }
}
