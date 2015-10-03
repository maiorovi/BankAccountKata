package banking

class Account {
  var amount:Money = Money(0.0)

  def add(mon: Money): Unit =  amount += mon

  def withDraw(mon: Money): Unit = {
    amount = (amount - mon).getOrElse {
      throw new NotEnoughMoneyException
    }
  }
}
