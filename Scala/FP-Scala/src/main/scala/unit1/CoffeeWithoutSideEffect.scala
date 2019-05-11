package unit1

/**
  * 不带副作用的购买计费
  */
class CoffeeWithoutSideEffect {
  // 买一杯咖啡, 返回咖啡obj,计费obj(信用卡,咖啡价格)
  def bufcoffee(cc:CreditCard):(Coffee,Charge) = {
    val cup = new Coffee(1.0)
    (cup,Charge(cc,cup.price))
  }
  
  // 购买多个咖啡
  def bufcoffees(cc:CreditCard,n:Int) : (List[Coffee],Charge) = {
    val purchases:List[(Coffee,Charge)] = List.fill(n)(bufcoffee(cc))
    val (coffees,charges) = purchases.unzip
    val sumCharge = charges.reduce( (c1,c2)=>c1.combine(c2) )
    (coffees,sumCharge)
  }
}


class CreditCard
case class Coffee(price:Double)

case class Charge(cc:CreditCard,price:Double){
  // 组合多个计费, 在信用卡相同的情况下
  def combine(other:Charge):Charge = {
    if (cc == other.cc)
      Charge(cc,price + other.price)
    else
      throw new Exception("Can't combine charges to different cards")
  }

  def coalesce(charges:List[Charge]):List[Charge] = {
    charges.groupBy(_.cc).values.map(_.reduce(_.combine(_))).toList
    // groupBy后, 产生Map
    // .values后, 取Map的value, 每个value是一个List
    // .map(_.reduce): 对每个list调用reduce方法
  }
}