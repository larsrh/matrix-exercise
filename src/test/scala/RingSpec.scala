package exercise

import org.scalacheck._

import org.specs2.mutable.Specification
import org.specs2.matcher._

class RingSpec extends Specification with ScalaCheckMatchers {

  val ring = implicitly[Ring[Int]]

  "int ring" should {

    "add correctly" in prop { (x: Int, y: Int) =>
      ring.plus(x, y) must be_===(x + y)
    }

    "multiply correctly" in prop { (x: Int, y: Int) =>
      ring.times(x, y) must be_===(x * y)
    }

    "respect additive identity" in prop { (x: Int) =>
      ring.plus(x, ring.zero) must be_===(x)
    }

    "respect multplicative identity" in prop { (x: Int) =>
      ring.times(x, ring.one) must be_===(x)
    }

  }

}

// vim: expandtab:ts=2:sw=2
