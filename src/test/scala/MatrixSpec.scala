package exercise

import org.scalacheck._

import org.specs2.mutable.Specification
import org.specs2.matcher._

class MatrixSpec extends Specification with ScalaCheckMatchers {

  val ring = implicitly[Ring[Int]]

  "int ring" should {

    "add correctly" in prop { (x: Int, y: Int) =>
      ring.plus(x, y) must be_===(x + y)
    }

    "multiply correctly" in prop { (x: Int, y: Int) =>
      ring.times(x, y) must be_===(x * y)
    }

  }

  "scalar product" should {

    "not modify when multiplying with 1" in prop { (matrix: Matrix[Int]) =>
      matrix.scalarProduct(ring.one) must be_===(matrix)
    }

  }

  "matrix multiplication" should {

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
