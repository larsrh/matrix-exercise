package exercise

case class Matrix[A](elements: Vector[Vector[A]])(implicit ring: Ring[A]) {
 
  def scalarProduct(s: A): Matrix[A] = ???
 
  def matrixProduct(that: Matrix[A]): Matrix[A] = ???
 
}
