package banking

class Money(val amount: Double) {
  def +(mon: Money):Money = new Money(mon.amount+amount)
  def <(mon: Money):Boolean = amount < mon.amount
  def -(mon: Money):Option[Money] = if (amount >= mon.amount) Option(new Money(amount - mon.amount)) else Option.empty[Money]
  def this(amnt: MoneyAmount) = this(amnt.amount)

  override def equals(obj: Any) = obj match {
    case that: Money => that.amount == this.amount;
    case _ => false;
  }
}

object Money {
  def apply(amount:Double): Money = new Money(amount)
  def apply(amount:MoneyAmount): Money = new Money(amount)
}
