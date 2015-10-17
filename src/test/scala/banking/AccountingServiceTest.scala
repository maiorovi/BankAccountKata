package banking

import org.scalatest.{BeforeAndAfter, FunSuite}

class AccountingServiceTest extends FunSuite with BeforeAndAfter {

  private val service = new DefaultAccountingService;
  private var acc = new Account

  before {

  }

  test("when zero added to account then amount doesn`t change") {
    service.add(acc, Money(0))
    assert(acc.amount.amount == 0)
  }

  test("when non zero value added to account the amount will change") {
    service.add(acc, Money(5))
    assert(acc.amount.amount == 5)
  }

  test("when money withdrawn from account, amount decreases") {
    acc = new Account(Money(5))
    service.withDrawal(acc, Money(3))

    assert(acc.amount.amount == 2)
  }

  test("exception is throw when amount is less then withdrawn amount") {
    intercept[NotEnoughMoneyException] {
      service.withDrawal(acc, Money(10))
    }
  }

  test("transfer to another account specified amount of money") {
    acc = new Account
    val other = new Account

    service.add(acc, Money(10))
    service.transfer(acc, other, Money(7));

    assert(other.amount.amount == 7.0)
    assert(acc.amount.amount == 3.0)
  }

  test("when attempted to transfer to another account amount higher then available then exception is thrown") {
    val other = new Account

    service.add(acc, Money(10))

    intercept[NotEnoughMoneyException] {
      service.transfer(acc, other, Money(15))
    }
  }
}
