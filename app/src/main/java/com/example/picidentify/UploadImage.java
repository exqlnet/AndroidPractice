package com.example.picidentify;

import java.io.Serializable;

public class UploadImage implements Serializable {

    String image;

    String image_type;

    String face_type;

    String quality_control;

    String liveness_control;

    UploadImage(String img) {
        this.image = img;
        this.image_type = "BASE64";
    }
}
