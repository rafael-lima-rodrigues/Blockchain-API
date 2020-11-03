package com.blockchain.service;

import com.blockchain.model.DocumentsSigned;
import com.blockchain.model.TransactionHistory;
import com.blockchain.model.query.RichQuery;

import java.util.List;

public interface DigitalSignService {

    DocumentsSigned getById(String id);

    void save(DocumentsSigned documentsSigned);

    void update(String key, DocumentsSigned documentsSigned);

    List<DocumentsSigned> query(RichQuery query);

    void delete(String id);

    List<DocumentsSigned> getAll();

    List<TransactionHistory> getHistory(String id);
}
