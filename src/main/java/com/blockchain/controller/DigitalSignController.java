package com.blockchain.controller;

import com.blockchain.model.DigitalDocument;
import com.blockchain.model.query.RichQuery;
import com.blockchain.service.DigitalSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DigitalSignController {

    @Autowired
    DigitalSignService digitalSignService;

    @GetMapping("/get/{id}")
    @ResponseBody
    ResponseEntity<DigitalDocument> get(@PathVariable("id") String id) {
        Optional<DigitalDocument> documentsData = Optional.ofNullable(digitalSignService.getById(id));

        if (documentsData.isPresent()){
            return new ResponseEntity<>(documentsData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    ResponseEntity<List<DigitalDocument>> getAll() {
        try {
            List<DigitalDocument> digitalDocuments = new ArrayList<>();
            digitalSignService.getAll().forEach(digitalDocuments::add);
            if (digitalDocuments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(digitalDocuments, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    ResponseEntity<DigitalDocument> save(@RequestBody DigitalDocument digitalDocument) {

        try {
            digitalSignService.save(digitalDocument);
            return new ResponseEntity<>(digitalDocument, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{id}")
    ResponseEntity<DigitalDocument> update(@PathVariable("id") String id,
                                           @RequestBody DigitalDocument digitalDocument){
        Optional<DigitalDocument> documentData = Optional.ofNullable(digitalSignService.getById(id));

        if (documentData.isPresent()){

            DigitalDocument _digitalDocument = documentData.get();
            _digitalDocument.setDescription(digitalDocument.getDescription());
            _digitalDocument.setData(digitalDocument.getData());
            _digitalDocument.setUserIdOwner(digitalDocument.getUserIdOwner());
            _digitalDocument.setSignature(digitalDocument.getSignature());
            digitalSignService.update(id, _digitalDocument);
            return new ResponseEntity<>(_digitalDocument, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<DigitalDocument> delete(@PathVariable ("id") String dsId) {
        try {
            digitalSignService.delete(dsId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/query")
    List<DigitalDocument> query(@RequestParam(required = false) String type,
                                  @RequestParam String userId) {
        RichQuery query = new RichQuery();
        Map<String, Object> selector = new HashMap<>();
        if (type != null && !type.isEmpty()) {
            selector.put("typeDoc", "DocsCreated");
            query.setSelector(selector);


        }
        return digitalSignService.query(query);
    }

}
