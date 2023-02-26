package com.aydin.utils;

import org.springframework.http.HttpStatus;

public class TransactionStatus {

    private HttpStatus status;
    private String approvalCode;

    public TransactionStatus(HttpStatus status, String approvalCode) {
        this.status = status;
        this.approvalCode = approvalCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}
