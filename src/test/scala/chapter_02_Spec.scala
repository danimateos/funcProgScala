import org.specs2.mutable.Specification
import com.mateos.chiusano.Chapter_02


object Chapter_02_Spec extends Specification {

  "Exercise 2.1's fibonacci" should {
    "correctly calculate the first ten numbers in the Fibonacci Sequence" in {
      (0 to 10).map(Chapter_02.fibonacci) mustEqual List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
    }
  }
  
  "Exercise 2.2's isSorted" should {
    val sortedArray = Array(1,2,3,4,5)
    val unsorted = Array(4,3,5,1)

    "handle arrays of Ints" in {

      def less(a:Int, b:Int): Boolean = a<b
      def more(a:Int, b:Int): Boolean = a>b

      Chapter_02.isSorted(sortedArray, less) must beTrue
      Chapter_02.isSorted(unsorted, less) must beFalse
      Chapter_02.isSorted(sortedArray.reverse, more) must beTrue


    }
    "handle arrays of Strings" in {
      def before(a:String, b: String): Boolean = a<b
      def after(a:String, b: String): Boolean = a>b

      Chapter_02.isSorted(sortedArray.map(_.toString), before) must beTrue
      Chapter_02.isSorted(unsorted.map(_.toString), before) must beFalse
      Chapter_02.isSorted(sortedArray.reverse.map(_.toString), after) must beTrue

    }
  }

  
}
