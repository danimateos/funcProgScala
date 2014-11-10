import org.specs2.mutable.Specification
import com.mateos.chiusano.Chapter_03


object Chapter_03_Spec extends Specification {

  val list1 = 1 :: 3 :: 4 :: 5 :: 6 :: Nil
  val list2 = 3 :: 2 :: 1 :: 5 :: 6 :: Nil
  val list3 = 6 :: 5 :: 4 :: 3 :: 2 :: Nil

  "The 'tail' method" should {
    "work" in {
      Chapter_03.tail(list1) mustEqual 3 :: 4 :: 5 :: 6 :: Nil
      //Chapter_03.tail(list2) mustEqual 2 :: 1 :: 5 :: 6 :: Nil
      //Chapter_03.tail(list3) mustEqual 5 :: 4 :: 3 :: 2 :: Nil
    }
  }

  "The 'setHead' method" should {
    "work" in {
      Chapter_03.setHead(2, list1) mustEqual 2 :: 3 :: 4 :: 5 :: 6 :: Nil
      Chapter_03.setHead(2, list2) mustEqual 2 :: 2 :: 1 :: 5 :: 6 :: Nil
    }
  }

  "The 'drop' method" should {
    "return Nil" in {
      Chapter_03.drop(list1, 5) mustEqual Nil
    }
    "drop n" in {
      Chapter_03.drop(list1, 3).length mustEqual list1.length-3
    }
  }

  "The 'dropWhile' method" should {
    "work" in {
      Chapter_03.dropWhile(list3, (x: Int) => x > 3) mustEqual 3 :: 2 :: Nil
    }
  }

  "The 'length' method using foldRight" should {
    "compute the correct length of lists" in {
      Chapter_03.length(list1) mustEqual 5
      Chapter_03.length(Nil) mustEqual 0
      Chapter_03.length(List("a", "b", "c")) mustEqual 3
    }
  }

  "The functions using 'foldLeft' from exercise 3.11"  should {
    "produce the same output as the in-built equivalents" in {
      Chapter_03.sumWithFoldLeft(list1) mustEqual list1.sum
      Chapter_03.productWithFoldLeft(list1) mustEqual list1.product
      Chapter_03.lengthWithFoldLeft(list1) mustEqual list1.length

      Chapter_03.sumWithFoldLeft(list2) mustEqual list2.sum
      Chapter_03.productWithFoldLeft(list2) mustEqual list2.product
      Chapter_03.lengthWithFoldLeft(list2) mustEqual list2.length

      Chapter_03.sumWithFoldLeft(list3) mustEqual list3.sum
      Chapter_03.productWithFoldLeft(list3) mustEqual list3.product
      Chapter_03.lengthWithFoldLeft(list3) mustEqual list3.length
    }
  }

  "The reverse functions from exercise 3.12" should {
    "produce the same output as the in-built equivalents" in {
      Chapter_03.reverseWithFoldLeft(list1) mustEqual list1.reverse
      Chapter_03.reverseWithFoldLeft(list2) mustEqual list2.reverse
      Chapter_03.reverseWithFoldLeft(list3) mustEqual list3.reverse
    }

    "have been implemented standalone" in {
      "notDone" mustEqual "done"

    }

    "have been implemented with foldLeft" in {
      "done" mustEqual "done"
    }

    "have been implemented with foldRight" in {
      "notDone" mustEqual "done"
    }
  }

  "Exercise 3.13" should {
    "be" in {
      "notDone" mustEqual "done"
    }
  }

  "Exercise 3.14's 'append'" should {
    "produce the same output as the in-built equivalent" in {
      Chapter_03.append(12, list1) mustEqual list1 ++ (12 :: Nil)
      Chapter_03.append(12, list2) mustEqual list2 ++ (12 :: Nil)
      Chapter_03.append(12, list3) mustEqual list3 ++ (12 :: Nil)
    }
  }

}
