package banking

import java.util.Calendar

import banking.StatementType.StatementType


class Statement(val date:String, val amount: Money, val statementType: StatementType) {
  override def toString = Calendar.getInstance().getTime.toString + "  Amount: " + amount.amount
}

object StatementType extends Enumeration {
  type StatementType = Value
  val DEPOSIT, WITHDRAWAL, TRANSFER = Value;
}
