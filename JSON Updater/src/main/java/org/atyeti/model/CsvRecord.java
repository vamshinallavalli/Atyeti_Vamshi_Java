package org.atyeti.model;

public class CsvRecord {
    public String employeeId;
    public String operation;
    public String path;
    public String oldValue;
    public String newValue;

    public CsvRecord(String[] parts) {
        this.employeeId = parts[0];
        this.operation = parts[1];
        this.path = parts[2];
        this.oldValue = parts[3];
        this.newValue = parts[4];
    }
}