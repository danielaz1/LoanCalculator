package com.daniela.calc.web.application;

import com.daniela.calc.loan.domain.LoanInfo;
import com.daniela.calc.loan.domain.LoanResult;
import com.daniela.calc.loan.service.LoanCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CalcController {

    @Autowired
    private LoanCalculatorService loanCalculatorService;

    @GetMapping("/calc")
    public String showPage(Model model) {
        model.addAttribute("loanInfo", new LoanInfo());
        return "calc";
    }

    @PostMapping("/calc")
    public String calcSubmit(@ModelAttribute LoanInfo loanInfo, Model model) {
        LoanResult loanResult = loanCalculatorService.getLoanResult(loanInfo);
        model.addAttribute("loanResult", loanResult);

        return "result";
    }


}

