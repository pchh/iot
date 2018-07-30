package com.lotte.ai.dto;

import java.util.List;

public class AnalysisDTO {
    private List<AnalysisImageDTO> imageData;
    private String analysisSpeed;

    public List<AnalysisImageDTO> getImageData() {
        return imageData;
    }

    public AnalysisDTO setImageData(List<AnalysisImageDTO> imageData) {
        this.imageData = imageData;
        return this;
    }

    public String getAnalysisSpeed() {
        return analysisSpeed;
    }

    public AnalysisDTO setAnalysisSpeed(String analysisSpeed) {
        this.analysisSpeed = analysisSpeed;
        return this;
    }
}
