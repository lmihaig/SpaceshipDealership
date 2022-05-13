package com.spaceshipdealership.services;


public class AuditService {


    private static AuditService INSTANCE;

    private static final String FILE_PATH = "data/Audit.csv";

    private AuditService() {

    }

    public static AuditService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuditService();
        }
        return INSTANCE;
    }

    void AuditWrite() {

    }
}
