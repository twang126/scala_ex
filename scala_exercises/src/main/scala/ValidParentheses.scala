object ValidParentheses extends App {
    def isValid(s: String): Boolean = {
        def inner(str: List[Char], stck: List[Char]): Boolean = {
            (str, stck) match {
                case ('('::t, _) => inner(t, ')'::stck)
                case ('{'::t, _) => inner(t, '}'::stck)
                case (lh::lt, sh::st) => lh == sh && inner(lt, st)
                case _ => str.isEmpty && stck.isEmpty
            }
        }

        inner(s.toList, List.empty)
    }
  
    println(isValid("(({}))"))
    println(isValid("(({))"))
    println(isValid("{)"))
}
