package com.science.earth.biogeochemistry.freshwaters.pandora.objects;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadForm {
    private MultipartFile fileToUpload;

    /**
     * @return the fileToUpload
     */
    public MultipartFile getFileToUpload() {
        return this.fileToUpload;
    }

    /**
     * @param fileToUpload the fileToUpload to set
     */
    public void setFileToUpload(MultipartFile fileToUpload) {
        this.fileToUpload = fileToUpload;
    }
}
