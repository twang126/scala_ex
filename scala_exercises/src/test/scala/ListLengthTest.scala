class ListLengthTest extends munit.FunSuite {
  test("ListLength.getListLength") {
    assert(ListLength.getListLength(List(0, "1", 2, 3, 4, 5, 6)) == 7)
  }

  test("ListLength.getListLengthFold") {
    assert(ListLength.lengthFold(List(0, "1", 2, 3, 4, 5, 6)) == 7)
  }
}
