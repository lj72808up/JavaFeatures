package unit4

sealed trait Option[+A] {
  def map[B](f:A=>B):Option[B] = {
    this match {
      case None => None
      case Some(get) => Some(f(get))
    }
  }

  /**
    * @param default : 无参的匿名函数, 返回A的父类型
    * @tparam B
    * @return
    */
  def getOrElse[B>:A](default: =>B):B = {
    this match {
      case None => default
      case Some(get) => get
    }
  }

  def flatmap[B](f:A=>Option[B]):Option[B] = {
    map(f).getOrElse(None)
  }

  def filter(f:A=>Boolean):Option[A] = {
    this match {
      case Some(get) if(f(get)) => this
      case _ => None
    }
  }

  // 使用lift, 将在普通函数提升成操作Option类型的函数
  def lift[A,B](f:A=>B): Option[A]=>Option[B] = {
    _ map(f)
  }

  def abs0:Option[Double] => Option[Double] = lift(math.abs)

  override def toString: String = {
    this match {
      case Some(get) => s"Some($get)"
      case _ => "None"
    }
  }
}

case class Some[+A](get:A) extends Option[A]
case object None extends Option[Nothing]


object TestStdOption{
  def main(args: Array[String]): Unit = {
    val v1 = new Some(-1.123)
    println(v1.abs0(v1))

  }
}