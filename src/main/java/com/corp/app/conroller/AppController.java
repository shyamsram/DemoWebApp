package com.corp.app.conroller;

import com.corp.app.entities.Transaction;
import com.corp.app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {
    @Autowired
    TransactionRepository repository;

    @RequestMapping
    public String index() {
        return "First App running!!!";
    }

    @RequestMapping(path = "/app/trandetail/bytype/{tranType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Transaction getTransactionDetailForType (@PathVariable String tranType) {
        return repository.findByTranType(tranType).get(0);
    }

    @RequestMapping(path = "/app/trandetail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Transaction getTransactionDetailByTranId (@PathVariable Long id) {
        return repository.findOne(id);
    }
}
