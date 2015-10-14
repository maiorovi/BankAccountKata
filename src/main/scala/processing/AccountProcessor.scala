package processing

import java.util.Calendar

import banking.Account

class AccountProcessor {

  def getAccountStatement(acc: Account): String =  Calendar.getInstance().getTime.toString + "  Amount: " + acc.amount

}
