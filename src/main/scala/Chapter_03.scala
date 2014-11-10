package com.mateos.chiusano


object Chapter_03 {

  def tail[A](as: List[A]): List[A] = as match {
    case x :: xs => xs
    case Nil => Nil
  }

  def setHead[A] (a: A, as: List[A]): List[A] = as match {
    case x :: xs => a :: xs
    case _       => Nil
  }

  @annotation.tailrec
  def drop[A] (l: List[A], n: Int): List[A] = n match {
    case 0 => l
    case x => drop(l.tail, n-1)
  }

  @annotation.tailrec
  def dropWhile[A] (l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case x :: xs if !f(x) => x :: xs
    case x :: xs if f(x)  => dropWhile(xs, f)
  }

  def init[A](l: List[A]): List[A] = l match {
    case x :: Nil => Nil
    case x :: xs => x :: init(xs)
  }

  def foldRight[A,B] (as: List[A], z: B) (f: (A, B) => B): B = as match {
    case Nil => z
    case x :: xs => f(x, foldRight(xs, z) (f))
  }

  def length[A] (l: List[A]): Int = foldRight(l, 0) ((x, y) => y + 1)

  // 3.7: 

  // 3.8: it returns the same list. That means Nil and Cons() are the
  // identity operators of foldRight.

  def foldLeft[A, B] (as: List[A], z: B) (f: (A, B) => B): B = as match {
    case Nil     => z
    case x :: xs => foldLeft(xs, f(x, z)) (f)
  }

  def sumWithFoldLeft(as: List[Int]): Int = foldLeft(as, 0) (_ + _)

  def productWithFoldLeft(as: List[Int]): Int = foldLeft(as, 1) (_ * _)

  def lengthWithFoldLeft[A](as: List[A]): Int = foldLeft(as, 0) {(x, z) => z + 1}

//  def reverseWithoutFold[A] (as: List[A]): List[A] = 

/*  def reverseWithFoldRight[A] (as: List[A]): List[A] = as match {
    case Nil => Nil
    case x :: xs => foldRight(xs, x :: Nil) {(a,z) => z :: a}
  }*/

  def reverseWithFoldLeft[A] (as: List[A]): List[A] = as match {
    case Nil => Nil
    case x :: xs => foldLeft(xs, x :: Nil) {(a,z) => a :: z}
  }

  def append[A](a: A, as: List[A]): List[A] = foldRight(as, a :: Nil) ((a, z) => a :: z)

// def flatten[A] (as: List[List[A]]): List[A] = 
}
