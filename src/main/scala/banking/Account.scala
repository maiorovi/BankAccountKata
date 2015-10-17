package banking

import java.text.SimpleDateFormat
import java.util.Date

import banking.StatementType.StatementType

import scala.collection.mutable

class Account {
  private[this] val dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  var amount:Money = Money(0.0)
  var accountJournal:mutable.MutableList[Statement] = mutable.MutableList()
  
  def this(initialAmount: Money) {
    this()
    amount = new Money(initialAmount.amount);
    accountJournal += new Statement(getCurrentDate, initialAmount, StatementType.DEPOSIT)
  }

  private def getCurrentDate():String = dateFormat.format(new Date())

  def fileterByDepositType(statementType: StatementType): List[Statement] = accountJournal.filter(x => x.statementType != statementType).toList

}
