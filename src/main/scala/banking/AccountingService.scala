package banking

trait AccountingService {
  def add(acc: Account, money:Money)
  def withDrawal(acc:Account, money:Money)
  def transfer(accFrom:Account, accTo:Account, amount:Money)
}
