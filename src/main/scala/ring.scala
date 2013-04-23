package exercise

trait Ring[A] {
 
  def plus(x: A, y: A): A
  def times(x: A, y: A): A
 
  def zero: A
  def one: A
 
}

object Ring {

  implicit object IntRing extends Ring[Int] {

    def plus(x: Int, y: Int) = x + y
    def times(x: Int, y: Int) = x * y

    def zero = 0
    def one = 1

  }

}

// vim: expandtab:ts=2:sw=2
