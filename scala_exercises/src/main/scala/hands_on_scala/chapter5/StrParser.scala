package hands_on_scala.chapter5;

trait StrParser[T]{ def parse(s: String): T }

object StrParser extends App {
    implicit object ParseInt extends StrParser[Int] {
        def parse(s: String): Int = s.toInt
    }

    implicit object ParseBoolean extends StrParser[Boolean] { 
        def parse(s: String): Boolean = s.toBoolean
    }

    implicit def ParseSeq[T](implicit p: StrParser[T]): StrParser[Seq[T]] = new StrParser[Seq[T]] {
        def parse(s: String) = s.split(",").toSeq.map(p.parse)
    }

    implicit def ParseTuples[T, V](implicit p1: StrParser[T], p2: StrParser[V]): StrParser[(T,V)] = {
        new StrParser[(T,V)] { 
            def parse(s: String): (T, V) = {
                val Array(left, right) = s.split(":")
                p1.parse(left) -> p2.parse((right))
            }
        }
    }

    def parseString[T: StrParser](s: String) = {
        implicitly[StrParser[T]].parse(s)
    }

    println(parseString[Int]("124"))
    println(parseString[Seq[Int]]("12,4"))
    println(parseString[(Int, Boolean)](("12:true")))
}