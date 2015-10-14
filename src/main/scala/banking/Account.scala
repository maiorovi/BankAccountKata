package banking

class Account {
  var amount:Money = Money(0.0)

  def this(initialAmount: Money) {
    this()
    amount = new Money(initialAmount.amount);
  }

  def add(mon: Money): Unit =  amount += mon

  def withDraw(mon: Money): Unit = {
    amount = (amount - mon).getOrElse {
      throw new NotEnoughMoneyException
    }
  }

  def transferTo(acc: Account, amount: MoneyAmount): Unit = {
    val money = Money(amount)
    this.withDraw(money)
    acc.add(money)
  }
}
