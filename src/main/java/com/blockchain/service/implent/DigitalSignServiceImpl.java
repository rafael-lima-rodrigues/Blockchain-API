package com.blockchain.service.implent;

import com.blockchain.model.DigitalDocument;
import com.blockchain.model.TransactionHistory;
import com.blockchain.model.query.RichQuery;
import com.blockchain.repository.DigitalSignDAO;
import com.blockchain.service.DigitalSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigitalSignServiceImpl implements DigitalSignService {

    @Autowired
    DigitalSignDAO digitalSignDAO;

    @Override
    public DigitalDocument getById(String id) {
        return digitalSignDAO.getbyId(id);
    }

    @Override
    public void save(DigitalDocument digitalDocument) {
        digitalSignDAO.save(digitalDocument);
    }

    @Override
    public void update(String key, DigitalDocument digitalDocument) {
       digitalSignDAO.update(key, digitalDocument);
    }

    @Override
    public List<DigitalDocument> query(RichQuery query) {
        return digitalSignDAO.query(query);
    }

    @Override
    public void delete(String id) {
        digitalSignDAO.delete(id);
    }

    @Override
    public List<DigitalDocument> getAll() {
        return digitalSignDAO.getAll();
    }

    @Override
    public List<TransactionHistory> getHistory(String id) {
        return digitalSignDAO.getHistory(id);
    }
}
