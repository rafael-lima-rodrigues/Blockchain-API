package com.blockchain.service;

import com.blockchain.model.DigitalDocument;
import com.blockchain.model.TransactionHistory;
import com.blockchain.model.query.RichQuery;

import java.util.List;

public interface DigitalSignService {

    DigitalDocument getById(String id);

    void save(DigitalDocument digitalDocument);

    void update(String key, DigitalDocument digitalDocument);

    List<DigitalDocument> query(RichQuery query);

    void delete(String id);

    List<DigitalDocument> getAll();

    List<TransactionHistory> getHistory(String id);
}
