package banking

class Money(val amount: Double) {
  def +(mon: Money):Money = new Money(mon.amount+amount)
  def <(mon: Money):Boolean = amount < mon.amount
  def -(mon: Money):Option[Money] = if (amount > mon.amount) Option(new Money(amount - mon.amount)) else Option.empty[Money]
}

object Money {
  def apply(amount:Double): Money = new Money(amount)
}
