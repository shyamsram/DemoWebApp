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

/**
 * This controller servers requests for Transaction details
 *
 */
@RestController
public class AppController {

    /**
     * Autowiring repository
     */
    @Autowired
    TransactionRepository repository;

    /**
     * Default request handler
     *
     * @return string hello message
     */
    @RequestMapping
    public String index() {
        return "First App running!!!";
    }

    /**
     * method to return transactions by type
     *
     * @param tranType
     * @return Transaction
     */
    @RequestMapping(path = "/app/trandetail/bytype/{tranType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Transaction getTransactionDetailForType (@PathVariable String tranType) {
        return repository.findByTranType(tranType).get(0);
    }

    /**
     * method to return transaction based on Id
     *
     * @param id
     * @return transaction object
     */
    @RequestMapping(path = "/app/trandetail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Transaction getTransactionDetailByTranId (@PathVariable Long id) {
        return repository.findOne(id);
    }
}
