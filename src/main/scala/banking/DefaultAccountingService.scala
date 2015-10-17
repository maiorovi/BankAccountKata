package banking

import java.text.SimpleDateFormat
import java.util.Date

class DefaultAccountingService extends AccountingService {

  private[this] val dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

  override def add(acc: Account, money: Money): Unit = {
    acc.amount += money
    acc.accountJournal += new Statement(getCurrentDate, acc.amount, StatementType.DEPOSIT)
  }

  override def transfer(accFrom: Account, accTo: Account, amount:Money): Unit = {
    withDrawal(accFrom, amount)
    add(accTo, amount)
  }

  override def withDrawal(acc: Account, money: Money): Unit =  {
    acc.amount = (acc.amount - money).getOrElse {
      throw new NotEnoughMoneyException
    }
    acc.accountJournal += new Statement(getCurrentDate, money, StatementType.WITHDRAWAL)
  }

  private def getCurrentDate():String = dateFormat.format(new Date())
}
