package banking

import org.scalatest.{BeforeAndAfter, FunSuite}

class AccountTest extends FunSuite with BeforeAndAfter {

  private[this] var acc:Account = null;

  before {
    acc = new Account
  }

  test("initial account amount is zero") {
    assert(acc.amount.amount == 0)
  }

  test("when zero added to account then amount doesn`t change") {
    acc.add(Money(0))
    assert(acc.amount.amount == 0)
  }

  test("when non zero value added to account the amount will change") {
    acc.add(Money(5))
    assert(acc.amount.amount == 5)
  }
  
  test("when money withdrawn from account, amount decreases") {
    acc.add(Money(5))
    acc.withDraw(Money(3))

    assert(acc.amount.amount == 2)
  }

  test("exception is throw when amount is less then withdrawn amount") {
    intercept[NotEnoughMoneyException] {
      acc.withDraw(Money(10))
    }
  }
}
