package banking

import org.scalatest.{BeforeAndAfter, FunSuite}

class MoneyTest extends FunSuite with BeforeAndAfter{

  private var mon1 = Money(10.5)
  private var mon2 = Money(5.7)

  before {
    mon1 = Money(10.5)
    mon2 = Money(5.7)
  }

  test("money has amount propertie") {
    assert(mon1.amount == 10.5)
  }

  test("money can be added to create new money instance with common amount") {
    val result = mon1 + mon2

    assert(result.amount == 16.2)
  }

  test("money can be compared to each other") {
    assert((mon2 < mon1) == true)
  }

  test("money can be subtracted") {
    val result = mon1 - mon2
    assert(result.get.amount == 4.8)
  }

  test("empty option returned if left arg less then right") {
    val result = mon2 - mon1
    assert(result.isEmpty == true)
  }


}
