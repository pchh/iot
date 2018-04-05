package com.lotte.ai.dto;

public class AnalysisImageDTO {
    private String objectName;
    private String objectPercent;

    public String getObjectName() {
        return objectName;
    }
    public AnalysisImageDTO setObjectName(String objectName) {
        this.objectName = objectName;
        return this;
    }

    public String getObjectPercent() {
        return objectPercent;
    }
    public AnalysisImageDTO setObjectPercent(String objectPercent) {
        this.objectPercent = objectPercent;
        return this;
    }

    @Override
    public String toString() {
        return "AnalysisImageVO [objectName=" + objectName + ", objectPercent=" + objectPercent + "]";
    }
}