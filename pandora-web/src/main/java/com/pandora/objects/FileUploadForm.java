package com.pandora.objects;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {
    /**
     * The file to be uploaded.
     */
    private MultipartFile fileToUpload;

    /**
     * Gets the file to be uploaded.
     *
     * @return The file to be uploaded.
     */
    public MultipartFile getFileToUpload() {
        return this.fileToUpload;
    }

    /**
     * Sets the file to be uploaded.
     *
     * @param fileToUploadParam The file to be uploaded.
     */
    public void setFileToUpload(final MultipartFile fileToUploadParam) {
        this.fileToUpload = fileToUploadParam;
    }
}
