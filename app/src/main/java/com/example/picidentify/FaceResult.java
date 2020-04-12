package com.example.picidentify;

public class FaceResult {

    Integer error_code = 0;

    String error_msg;

    Long log_id;

    Long timestamp;

    Integer cached;

    public static class Result {
        public Double score;
    }

    Result result = new Result();
}
