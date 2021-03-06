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

  def increment (as: List[Int]): List[Int] = as match {
    case Nil => Nil
    case x :: xs => (x + 1) :: increment(xs)
  }

  def doublesToString (as: List[Double]): List[String] = as match {
    case Nil => Nil
    case x :: xs => x.toString :: doublesToString(xs)
  }

  def map[A,B] (as: List[A]) (f: A => B): List[B] = as match {
    case Nil => Nil
    case x :: xs => f(x) :: map(xs) (f)
  }

  def filter[A] (as: List[A]) (f: A => Boolean): List[A] = as match {
    case Nil => Nil
    case x :: xs => if (f(x)) x :: filter(xs) (f) else filter (xs) (f)
  }

//  def flatMap[A,B](as: List[A]) (f: A => List[B]) = 

// def filterWithFlatMap[A] (as: List[A]) (f: A => Boolean): List[A] = 

  def zipInts(as: List[Int], bs: List[Int]): List[Int] = (as, bs) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (x :: xs, y :: ys) => (x + y) :: zipInts(xs, ys)
  }

  def zipWith[A,B,C] (as: List[A], bs: List[B]) (f: (A,B) => C): List[C] = (as, bs) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (x :: xs, y :: ys) => f(x, y) :: zipWith(xs, ys) (f)
  }

//  def hasSubsequence[A] (sup: List[A], sub: List[A]): Boolean =

  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => size(l) + size(r) + 1
  }

  def maximum (t: Tree[Int]): Int = t match {
    case Leaf(v) => v
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  def depth[A] (t: Tree[A]): Int = t match {
    case Leaf(_) => 0
    case Branch(l, r) => depth(l) max depth(r) + 1
  }

  def map[A,B] (t: Tree[A]) (f: A => B): Tree[B] = t match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

  def fold[A,B,C] (t: Tree[A], z: B) (f: (A, B) => C): Tree[C] = t match {
    case Leaf(v) => Leaf(f(v, z))
    case Branch(l, r) => Branch(fold(l, z)(f), fold(r, z)(f))
  }

}
