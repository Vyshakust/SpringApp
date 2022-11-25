package com.ust.claims.api.transaction;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Transaction getTransactionById(Integer id) {
        Transaction transactionById = transactionRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
        return transactionById;
    }

    public TransactionDto convertToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDto.class);
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public List<TransactionDto> convertToDtoList(List<Transaction> transactionList) {
        List<TransactionDto> transactionDTOList = new ArrayList<>();
        for(Transaction transaction : transactionList){
            transactionDTOList.add(modelMapper.map(transaction, TransactionDto.class));
        }
        return transactionDTOList;
    }

    public void saveTransaction(Transaction transaction) {
        transaction.setCreatedDate(LocalDateTime.now());
        transaction.setModifiedDate(transaction.getCreatedDate());
        transactionRepository.save(transaction);
    }
}
