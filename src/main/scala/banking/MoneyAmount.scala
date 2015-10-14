package banking

class MoneyAmount(val amount:Double)

object MoneyAmount {
  def apply(amount:Double) = new MoneyAmount(amount)
}
