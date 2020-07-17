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
  // 使用一种fold实现反转链表
  def reverse[A](l:List[A]):List[A] = {
    // 这里使用List[A()而不是Nil是必要的, 因为需要推断出类型
    foldLeft(l,List[A]())((h,acc)=>Cons(h,acc))
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
    foldLeft(l,0)((x,y)=>{print(s"${y}+${x} ; ");x+y})
  }
  // 通过foldleft实现fpoldright, 避免栈溢出
  def foldRightViaFoldLeft[A,B](l: List[A], init: B)(f: (A,B) => B): B ={
    foldLeft(reverse(l), init)((a,b) => f(a,b))
  }
  // 用fold实现append两个list.遍历深度只取决于l1
  def appendViaFold[A](l1:List[A],l2:List[A]):List[A] = {
    List.foldRight(l1,l2)((elem,acc)=>Cons(elem,acc))
  }

  /**
    * 3.4.1 更多操作函数
    */
  def add1(l:List[Int]):List[Int] = {
    foldLeft(l,List[Int]())((ele,l)=>Cons(ele+1,l))
  }

  /**
    * foldRight实现的map, 产出结果与原List顺序相同. 这是因为List也是右结合的, 本身就是一种递归结构
    */

  def map[A,B](l:List[A],f:A=>B):List[B] = {
    foldRight(l,Nil:List[B])((ele,l)=>Cons(f(ele),l))
  }
  def filter[A](l:List[A])(f:(A)=>Boolean): List[A] = {
    foldRight(l,List[A]())((head,tail)=> if(f(head)) Cons(head,tail) else tail)
  }

  /**
    * append连接2个列表, concat连接多个列表
    * @param l
    * @tparam A
    * @return
    */
  def concat[A](l:List[List[A]]):List[A] = {
    foldRight(l,List[A]())(append)
  }
  // flatMap(List(1,2,3))(x=>List(x,x)) = Cons(1,Cons(1,Cons(2,Cons(2,Cons(3,Cons(3,Nil))))))
  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] =
    concat(map(l,f))

  /**
    * 使两个列表对应位置的元素相加, 产生新的列表:
    * List(1,1,1),List(2,3,4) => List(3,4,5)
    */
  def addPairs(l1:List[Int],l2:List[Int]):List[Int] = {
    (l1,l2) match {
      case (_,Nil) => Nil
      case (Nil,_) => Nil
      case (Cons(h1,t1),Cons(h2,t2)) => Cons(h1+h2,addPairs(t1,t2))
    }
  }
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
    println(List.reverse(List(1,2,3,4)))
    println(List.appendViaFold(List(1,2,3),List(4,5,6)))
    println(List.add1(List(1,2,1)))
    println(List.map(List(1,2,3,4),(x:Int)=>2*x))
    println(List.filter(List(1,2,3,4))((x:Int)=>x%2==0))
    println(List.concat(List(List(1,2),List(3,4))))
    println(List.flatMap(List(1,2,3))(x=>List(x,x)))
    println(List.addPairs(List(1,1,1),List(2,3,4)))
  }
}

/** tips:
  * 因为纯函数不能修改变量和产生副作用, 因此, scala中的集合都是不可变的.
  * 比如ListA ++ ListB 产生一个新的ListC, 而这不会产生数据复制, 只会增加引用, 也因为scala集合是不可变的, 因此可以安全的共享数据而不必担心数据改变
  * https://github.com/fpinscala/fpinscala/blob/master/answers/src/main/scala/fpinscala/datastructures/List.scala
  */
