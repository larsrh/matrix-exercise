import org.scalacheck
import org.scalacheck._
import org.scalacheck.Arbitrary._

package object exercise {

  implicit def MatrixArbitrary[A : Arbitrary : Ring]: Arbitrary[Matrix[A]] =
    Arbitrary(
      for {
        rows <- Gen.choose(1, 3)
        cols <- Gen.choose(1, 3)
        entries <- Gen.listOfN(rows, Gen.listOfN(cols, arbitrary[A]).map(_.toVector))
      } yield Matrix(entries.toVector)
    )

}

// vim: expandtab:ts=2:sw=2
