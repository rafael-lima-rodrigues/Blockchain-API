package com.blockchain.util;

import com.blockchain.model.DigitalDocument;
import com.blockchain.model.TransactionHistory;
import com.blockchain.model.query.RichQuery;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;

import java.util.List;

public interface ChaincodeExecuter {

    String save(DigitalDocument digitalDocument);
    String executeTransactionDS(boolean invoke, String func, String[] args) throws InvalidArgumentException, ProposalException;
    public String update(String key, DigitalDocument newDocument);
    public String getObjectByKey(String digitalSignId);
    public String deleteObject(String id);
    public String query(RichQuery query);
    public List<TransactionHistory> getHistory(String key);


}
