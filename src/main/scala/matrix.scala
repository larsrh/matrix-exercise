package exercise

case class Matrix[A](elements: Vector[Vector[A]])(implicit ring: Ring[A]) {
 
  def scalarProduct(s: A): Matrix[A] = {
    val res =
      for (row <- elements) yield
        for (entry <- row) yield
          ring.times(s, entry)
    Matrix(res)
  }
 
  def matrixProduct(that: Matrix[A]): Matrix[A] = {
    // There are multiple ways to implement this. I find this one pretty
    // elegant, although it might not be very efficient.

    // This turns a matrix
    //   (a b c)
    //   (d e f)
    // into
    //   (a d)
    //   (b e)
    //   (c f)
    // That way, we can iterate over the *columns* of the second matrix.
    val transposed = that.elements.transpose

    val res =
      // for each row in the first matrix ...
      for (row <- this.elements) yield
        // ... and for each column in the second matrix ...
        for (col <- transposed) yield {
          // ... compute an entry in the result.

          val zipped = row zip col
          // here, zipped contains (a, b) pairs which need to be multiplied
          val multiplied =
            for ((x, y) <- zipped) yield
              ring.times(x, y)
          // now we just have to add those up
          multiplied.foldLeft(ring.zero)(ring.plus)

          // Note that the above can be written shorter as:
          //   (row, col).zipped.map(ring.times).foldLeft(ring.zero)(ring.plus)
          // :)
        }

    Matrix(res)
  }
 
}

// vim: expandtab:ts=2:sw=2
