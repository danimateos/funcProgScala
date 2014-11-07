package com.mateos.chiusano


object chapter_02 {

  def fibonacci(n: Int): Int = {

    //@annotation.tailrec
    def go(n: Int): Int = {
      if (n==0) 0
      else if (n==1) 1
      else go(n-1) + go(n-2)
    }

    go(n)
  }

  def main(args: Array[String]): Unit = {
    println("2.1 - Fibonacci")
    
    val check = (1 to 10).map{
      x => 
        (x,
          fibonacci(x))
    }.map(println)


  }


}
