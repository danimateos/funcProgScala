package com.mateos.chiusano


object Chapter_02 {

  def fibonacci(n: Int): Int = {
    //@annotation.tailrec
    def go(n: Int): Int = {
      if (n==0) 0
      else if (n==1) 1
      else go(n-1) + go(n-2)
    }
    go(n)
  }


  def isSorted[T] (as: Array[T], ordered: (T, T) => Boolean): Boolean = {
    if (as.length<=1) true
    else if (!ordered(as.head, as.tail.head)) false
    else isSorted(as.tail, ordered)
  }

  def curry[A, B, C] (f: (A, B) => C): A => (B => C) = {
    a => f(a, _)
  }

  def uncurry[A, B, C] (f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)    
  }

  def compose[A, B, C] (f: B => C, g: A => B): A => C = {
    x: A => f(g(x))
  }

}
