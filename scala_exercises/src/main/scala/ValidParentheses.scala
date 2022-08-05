import scala.collection.mutable.Stack
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

    def isValidProcedural(s: String): Boolean = {
        var stck = Stack[Char]()

        for (c <- s) {
            c match {
                case '(' => stck.push(')')
                case '{' => stck.push('}')
                case _ => if (stck.isEmpty || c != stck.pop()) return false
            }
        }

        stck.isEmpty
    }

    println(isValidProcedural("(({}))"))
    println(isValidProcedural("(({))"))
    println(isValidProcedural("{)"))
}
