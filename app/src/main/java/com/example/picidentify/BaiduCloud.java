package com.example.picidentify;

import android.util.Log;


import java.util.ArrayList;
import java.util.List;

public class BaiduCloud {

    static Double checkFace(String face1, String face2) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            List<UploadImage> pics = new ArrayList<>();
            pics.add(new UploadImage(face1));
            pics.add(new UploadImage(face2));
            Log.e("EEE", GsonUtils.toJson(pics));
            String param = GsonUtils.toJson(pics);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();
            Log.e("TAG", "获取Token：" + accessToken);

            String result = HttpUtil.post(url, accessToken, "application/json", param);

            FaceResult faceResult = GsonUtils.fromJson(result, FaceResult.class);

            if (faceResult.error_code != 0) {
                Log.e("EEE", faceResult.error_code + faceResult.error_msg);
                return -1.0;
            } else {
                return faceResult.score;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1.0;
    }

}
