package banking

import java.text.SimpleDateFormat

import org.scalatest.{BeforeAndAfter, FunSuite}

class AccountTest extends FunSuite with BeforeAndAfter {

  private[this] var acc: Account = null
  private[this] val dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

  before {
    acc = new Account
  }

  test("initial account amount is zero") {
    assert(acc.amount.amount == 0)
  }

  test("filters operations journal by operation type") {

  }

}
