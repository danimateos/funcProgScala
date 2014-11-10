package com.mateos.chiusano


object Chapter_04 {

  sealed trait Option[+A]
  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]


}
