package com.mkyong.web.controller;

import com.mkyong.web.model.Account;
import com.mkyong.web.model.Transaction;
import com.mkyong.web.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String viewAllTransactions(ModelMap model) {
        List<Transaction> transactions = transactionRepository.getAllTransaction();
        model.addAttribute("transactions", transactions);
        return "listTransaction";
    }

    @RequestMapping("/addTransactionForm")
    public String addTransactionForm() {
        return "transaction";
    }

    @RequestMapping("/addTransaction")
    public String addTransaction(@ModelAttribute Transaction transaction) {
        transactionRepository.createTransaction(transaction);
        return "redirect:/Transaction";
    }

    @RequestMapping(value = "/deleteTransaction/{id}", method = RequestMethod.GET)
    public String deleteTransaction(@PathVariable Integer id) {
        transactionRepository.deleteTransaction(id);
        return "redirect:/Transaction";
    }
}
