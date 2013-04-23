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

  }

}

// vim: expandtab:ts=2:sw=2
