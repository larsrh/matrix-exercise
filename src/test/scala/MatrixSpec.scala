package exercise

import org.scalacheck._

import org.specs2.mutable.Specification
import org.specs2.matcher._

class MatrixSpec extends Specification with ScalaCheckMatchers {

  val ring = implicitly[Ring[Int]]

  "scalar product" should {

    "not modify when multiplying with 1" in prop { (matrix: Matrix[Int]) =>
      matrix.scalarProduct(ring.one) must be_===(matrix)
    }

    "respect associativity" in prop { (matrix: Matrix[Int], x: Int, y: Int) =>
      matrix.scalarProduct(x).scalarProduct(y) must be_===(matrix.scalarProduct(ring.times(x, y)))
    }

  }

  "matrix product" should {

    "calculate Wikipedia example correctly" in {
      /*
      http://de.wikipedia.org/wiki/Matrix_%28Mathematik%29#Matrizenmultiplikation

      (1, 2, 3)
      (4, 5, 6)
      *
      (6, -1)
      (3,  2)
      (0, -3)
      =
      (12  -6)
      (39 -12)

      Assumption: First vector contains rows
      */
      Matrix(
        Vector(
          Vector(1,2,3),
          Vector(4,5,6)
        )
      ).matrixProduct(
      Matrix(
        Vector(
          Vector(6, -1),
          Vector(3, 2),
          Vector(0, -3))
        )
      ) must be_=== (
      Matrix(
        Vector(
          Vector(12, -6),
          Vector(39, -12))
        )
      )
    }

  }

}

// vim: expandtab:ts=2:sw=2
