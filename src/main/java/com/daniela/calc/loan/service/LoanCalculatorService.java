package com.daniela.calc.loan.service;

import com.daniela.calc.loan.domain.LoanInfo;
import com.daniela.calc.loan.domain.LoanResult;
import org.springframework.stereotype.Service;

@Service
public class LoanCalculatorService {

    public LoanResult getLoanresult(LoanInfo loanInfo) {
        LoanResult loanResult = calculateLoanResult(loanInfo);
        return loanResult;
    }

    private LoanResult calculateLoanResult(LoanInfo loanInfo) {

        int months = loanInfo.getMonths();

        double q=1+((loanInfo.getRate()/100)/12);
        double qpowm = Math.pow(q,months);
        double amount = loanInfo.getAmount();
        double monthlyPayment = amount * qpowm * ((q-1)/(qpowm-1));
        double totalInterest = monthlyPayment*months-amount;
        LoanResult loanResult = new LoanResult();
        loanResult.setMonthlyPayment(monthlyPayment);
        loanResult.setTotalPrincipalPaid(amount);
        loanResult.setTotalInterestPaid(totalInterest);

        return loanResult;
    }
}
