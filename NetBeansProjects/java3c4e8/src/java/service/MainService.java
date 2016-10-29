/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DocumentDao;
import db.Document;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

/**
 *
 * @author student
 */
@Named
@RequestScoped
public class MainService implements java.io.Serializable {

    private Document document;

    @Inject
    private DocumentDao documentDao;

    @Resource
    private UserTransaction utx;

    @PostConstruct
    public void init() {
        document = new Document();
    }

    public DocumentDao getDocumentDao() {
        return documentDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void adaugaDocument() {
        try {
            utx.begin();
            documentDao.adaugaDocument(document);
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
