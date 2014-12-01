package com.mateos.chiusano


object Chapter_04 {

  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case None => None
      case Some(thing) => Some(f(thing))
    }

    def flatMap[B](f: A => Option[B]): Option[B] = this match {
      case None => None
      case Some(thing) => f(thing)
    }
    
    def getOrElse[B >: A](default: => B): B = this match {
      case None => default
      case Some(thing) => thing
    }

    def orElse[B >: A](ob: => Option[B]): Option[B] = if (this == None) ob else this
    
    def filter(f: A => Boolean): Option[A] = this match {
      case None => None
      case Some(thing) => if (f(thing)) this else None
    }

  }

  case object None extends Option[Nothing]
  case class Some[+A](get: A) extends Option[A]

  def variance(xs: Seq[Double]): Option[Double] = {
    def mean(ys: Seq[Double]): Option[Double] = 
      if (ys.length == 0) None else Some(ys.sum / ys. length)
    mean(xs) flatMap (m => mean(xs.map(x => math.pow(x - m, 2))))
  }

  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = (a,b) match {
    case (Some(an), Some(bn)) => Some(f(an, bn))
    case _ => None
  }

}
