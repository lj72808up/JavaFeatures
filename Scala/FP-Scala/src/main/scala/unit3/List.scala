package unit3

/**
  * 单链表
  * @tparam A
  */
sealed trait List[+A]

/** (一)
  * List的2个构造器, 空List构造器Nil, 非空List构造器Cons[+A]
  * 非空的Cons以(head:A,tail:List[A])的形式出现, 通过模式匹配获取head,tail
  * case object和case class一样,都会生成hashcode, tostring等方法, 区别在于case object用于无参形式, case class用于有参形式
  */
case object Nil extends List[Nothing]
case class Cons[+A](head:A,tail:List[A]) extends List[A]   //Cons是construct的缩写,

/** (一)
  * List伴生对象
  */
object List{
  /** (一)
    * 尾递归, 利用head和tail求和求积
    * @param l
    * @return
    */
  def sum(l:List[Int]):Int = {
    l match {
      case Nil => 0
      case Cons(head,tail) => head + sum(tail)
    }
  }
  def product(l:List[Int]):Int = {
    l match {
      case Nil => 1
      case Cons(0,_) => 0
      case Cons(head,tail) => head * product(tail)
    }
  }

  /** (一)
    * 尾递归构造函数
    * @param eles
    * @tparam A
    * @return 伴生对象中的apply方法相当于工厂模式创建的对象, 类的构造器相当于new创建对象
    */
  def apply[A](eles:A*):List[A] = {
    if (eles.isEmpty)
      Nil
    else
      Cons(eles.head,apply(eles.tail:_*))
  }

  def append[A](l1:List[A],l2:List[A]):List[A] = {
    l1 match {
      case Nil => l2
      case Cons(head,tail) => Cons(head,append(tail,l2))   // 这种append,只对l1的数据进行复制, 因此相比于数组实现更加高效
    }
  }

  // exercise
  // (三)
  def tail[A](l:List[A]):List[A] = {
    l match {
      case Nil => throw new Exception("tail of empty list")
      case Cons(_,t) => t
    }
  }
  // (三)
  def setHead[A](l:List[A],ele:A):List[A] = {
    l match {
      case Nil => throw new Exception("set head of empty list")
      case Cons(head,tail) => Cons(ele,tail)
    }
  }
  // (三)
  def dropN[A](l:List[A],count:Int):List[A] = {
    if (count<=0)
      l
    else
      l match {
        case Nil=> Nil
        case Cons(_,tail) => dropN(tail,count-1)
      }
  }
  // (三)
  def dropWhile[A](l:List[A],f:A=>Boolean):List[A] = {
    l match {
      case Nil => Nil
      case Cons(head,tail) => {
        if (f(head))
          dropWhile(tail,f)
        else
          l
      }
    }
  }
  /**
    * 返回除最后一个元素外的所有元素
    * 会产生持续复制整个List,直到最后一个元素(不包括)
    * @param l
    * @tparam A
    * @return
    */
  def init[A](l:List[A]):List[A] = {
    l match {
      case Nil => Nil
      case Cons(_,Nil) => Nil
      case Cons(head,tail) => Cons(head,init(tail))
    }
  }

  /** (三)
    * 如上的sum, product, 具有很强的相似性, 都是尾递归调用相同操作进行计算, 因此, 可以抽象出通用的foldRight
    * 从右侧开始执行计算过程, init先与最右面的元素计算
    * foldRight在开始迭代之前, 必须一路遍历到列表末尾
    *
    * @param l
    * @param init: 初始值
    * @param f: 计算过程
    * @tparam A
    * @tparam B
    * @return
    */
  def foldRight[A,B](l:List[A],init:B)(f:(A,B)=>B):B = {
    l match {
      case Nil => init
      case Cons(head,tail) => f(head,foldRight(tail,init)(f))
    }
  }
  def sum2(l:List[Int]):Int = {
    foldRight(l,0)((x,y)=>{print(s"${x}+${y} ; "); x+y})
  }
  def length[A](l:List[A]):Int = {
    foldRight(l,0)((_,acc)=>acc+1)
  }

  /**
    * 如上的foldRight不是尾递归,可能发生stack overflow 可以写一个尾递归的foldeft
    */
  def foldLeft[A,B](l:List[A],init:B)(f:(A,B)=>B):B = {
    l match {
      case Nil => init
      case Cons(head,tail) => foldLeft(tail,f(head,init))(f)
    }
  }
  def sum3[A](l:List[Int]):Int = {
    foldLeft(l,0)((x,y)=>{print(s"${x}+${y} ; ");x+y})
  }
  //3.12
}


object Test{
  def main(args: Array[String]): Unit = {
    val as = List(1,2,3,4)
    println(as)   // Cons(1,Cons(2,Cons(3,Cons(4,Nil))))
    println(List.product(as))
    println(List.tail(as))
    println(List.setHead(as,99))
    println(List.dropN(as,2))
    println(List.dropWhile(as,(x:Int)=>x<=2))
    println(List.append(List(1,2),List(6,7)))
    println(List.init(as))
    println(List.sum2(List(2,3,4)))
    println(List.length(List(1,2,99)))
    println(List.sum3(List(3,4,7)))
  }
}

/**
  * 因为纯函数不能修改变量和产生副作用, 因此, scala中的集合都是不可变的.
  * 比如ListA ++ ListB 产生一个新的ListC, 而这不会产生数据复制, 只会增加引用, 也因为scala集合是不可变的, 因此可以安全的共享数据而不会改变
  */
