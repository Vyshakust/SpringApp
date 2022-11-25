package com.ust.claims.api.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transaction/{id}")
    public ResponseEntity<TransactionDto> get(@PathVariable Integer id){
        try{
            Transaction transaction = transactionService.getTransactionById(id);
            return new ResponseEntity<TransactionDto>(transactionService.convertToDto(transaction), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<TransactionDto>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionDto>> getAll() {
        try {
            List<Transaction> transactionList = transactionService.getAllTransaction();
            return new ResponseEntity<List<TransactionDto>>(transactionService.convertToDtoList(transactionList), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<TransactionDto>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> add(@RequestBody Transaction transaction){
        transactionService.saveTransaction(transaction);
        return new ResponseEntity<Transaction>(HttpStatus.OK);
    }
}
