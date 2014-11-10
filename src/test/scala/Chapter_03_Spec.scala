import org.specs2.mutable.Specification
import com.mateos.chiusano.Chapter_03


object Chapter_03_Spec extends Specification {

  val list1 = 1 :: 3 :: 4 :: 5 :: 6 :: Nil
  val list2 = 3 :: 2 :: 1 :: 5 :: 6 :: Nil
  val list3 = 6 :: 5 :: 4 :: 3 :: 2 :: Nil

  "The tail() method" should {
    "work" in {
      Chapter_03.tail(list1) mustEqual 3 :: 4 :: 5 :: 6 :: Nil
      //Chapter_03.tail(list2) mustEqual 2 :: 1 :: 5 :: 6 :: Nil
      //Chapter_03.tail(list3) mustEqual 5 :: 4 :: 3 :: 2 :: Nil
    }
  }

  "The setHead() method" should {
    "work" in {
      Chapter_03.setHead(2, list1) mustEqual 2 :: 3 :: 4 :: 5 :: 6 :: Nil
      Chapter_03.setHead(2, list2) mustEqual 2 :: 2 :: 1 :: 5 :: 6 :: Nil
    }
  }

  "The drop() method" should {
    "return Nil" in {
      Chapter_03.drop(list1, 5) mustEqual Nil
    }
    "drop n" in {
      Chapter_03.drop(list1, 3).length mustEqual list1.length-3
    }
  }

  "The dropWhile() method" should {
    "work" in {
      Chapter_03.dropWhile(list3, (x: Int) => x > 3) mustEqual 3 :: 2 :: Nil
    }
  }
}
