package com.example.demo.api;

import com.example.demo.TransactionStatus;
import com.example.demo.repo.ItemRepository;
import com.example.demo.repo.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    ItemRepository transactionItemRepo;

    @PostMapping
    public ResponseEntity<TransactionStatus> posTransactionPost(
            final @RequestBody TransactionDto dto
    ){
        TransactionStatus transactionStatus = validate(dto);
        TransactionVO vo = map(dto);
        vo.setStatus(transactionStatus);


        transactionItemRepo.save(vo);
        return new ResponseEntity<>(transactionStatus, HttpStatus.CREATED);
    }

    private TransactionVO map(TransactionDto dto) {
        TransactionVO vo = new TransactionVO(dto.getId(), dto.getStore(), dto.getQuantity(), dto.getCategory());
        return vo;
    }

    private TransactionStatus validate(TransactionDto dto){
        if (dto.getCategory().equals("control")){
            return TransactionStatus.PASSED;
        }
        return TransactionStatus.FAILED;
    };
}
