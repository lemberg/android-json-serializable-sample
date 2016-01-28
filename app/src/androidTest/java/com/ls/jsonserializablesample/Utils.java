package com.ls.jsonserializablesample;

import android.content.Context;
import android.content.res.AssetManager;

import com.ls.jsonserializablesample.objects.UserProfile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vverbytskyy on 1/28/16.
 */
public class Utils {

    private static final String UTF_8_CODING = "UTF-8";

    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public String loadJsonFromAsset(String assetName) {

        String outputJson = null;

        try {
            InputStream inputStream = context.getResources().getAssets().open(assetName, AssetManager.ACCESS_STREAMING);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            outputJson = new String(buffer, UTF_8_CODING);

        } catch (IOException ignore) {
            ignore.printStackTrace();
        }

        return outputJson;
    }

    public UserProfile getUserProfile() {
        return new UserProfile("test-username", "test-surname", 1);
    }

    public List<UserProfile> getUserProfileList() {

        List<UserProfile> profileList = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            profileList.add(getUserProfile(i));
        }

        return profileList;
    }

    public Map<String, UserProfile> getUserProfileMap() {

        Map<String, UserProfile> profileMap = new HashMap<>();

        for (int i = 1; i < 4; i++) {
            profileMap.put("test-" + i, getUserProfile(i));
        }

        return profileMap;
    }

    private UserProfile getUserProfile(int number) {
        String profileName = "test-username-" + number;
        String profileSurname = "test-surname-" + number;

        return new UserProfile(profileName, profileSurname, number);
    }
}
