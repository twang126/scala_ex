object Retry extends App {
  def retry[T](max: Int, delay: Int)(f: => T): T = {
    var tries = 0;
    var result: Option[T] = None
    var currentDelay = delay
    while (result == None) {
        try {
            result = Some(f)
        } 
        catch {
            case e: Throwable => {
                Thread.sleep(currentDelay)
                currentDelay *= 2
                tries += 1
                if (tries > max) {
                    throw e 
                } else {
                    println(s"failed, retry #$tries")
                }
            }
        }
    }

    result.get
  }

  val x: Int => Int = i => i + 1
  val r = retry(10, 1)(x)
  println(r(10))
}
