package processing

import java.util.Calendar

import banking.{Account, Money}
import org.scalatest.{BeforeAndAfter, FunSuite}

class AccountProcessorTest extends FunSuite with BeforeAndAfter{

  test("processor can print current account state") {
    val processor = new AccountProcessor
    val account = new Account(new Money(10))

    val state = processor.getAccountStatement(account);

    assert(state == Calendar.getInstance().getTime.toString + "  Amount: " + account.amount)
  }

}
