package com.example.picidentify;

import android.util.Log;

import junit.framework.TestCase;

public class GsonUtilsTest extends TestCase {

    public void testToJson() {
        Log.e("aaa", "hhh" + GsonUtils.toJson(new UploadImage("aaaa")));
    }
}