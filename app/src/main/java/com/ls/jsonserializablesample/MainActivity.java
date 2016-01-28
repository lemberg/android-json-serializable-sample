package com.ls.jsonserializablesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.reflect.TypeToken;
import com.ls.jsonserializablesample.objects.UserProfile;
import com.ls.utils.jsonserializable.JsonSerializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String name = "TestName";
        String surname = "TestSurname";
        int age = 20;

        UserProfile profile = new UserProfile(name, surname, age);

        String jsonProfile = JsonSerializable.toJson(profile);

        UserProfile userProfileFromJson = JsonSerializable.fromJsonUnsafe(UserProfile.class, jsonProfile);


        List<UserProfile> userProfileList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {

            String tmpName = name + i;
            String tmpSurname = name + i;
            int tmpAge = age + i;


            userProfileList.add(new UserProfile(tmpName, tmpSurname, tmpAge));
        }

        String jsonProfiles = JsonSerializable.toJson(userProfileList);

        List<UserProfile> userProfileListFromJson = JsonSerializable.toList(jsonProfiles, UserProfile.class);


        Map<Integer, UserProfile> userProfileMap = new HashMap<>();
        int i = 0;
        for (UserProfile profileItem : userProfileListFromJson) {
            userProfileMap.put(i, profileItem);
            i++;
        }

        String jsonMapProfiles = JsonSerializable.toJson(userProfileMap);

        Map<Integer, UserProfile> userProfileMapFromJson = JsonSerializable.toMap(jsonMapProfiles, Integer.class, UserProfile.class);



        List<List<UserProfile>> profileListLists = new ArrayList<>();

        for (int j = 0; j < 5; j++) {

            List<UserProfile> list = new ArrayList<>();
            list.add(new UserProfile("test" + j, "test" + j, j));

            profileListLists.add(list);
        }

        String listListStr = JsonSerializable.toJson(profileListLists);

    }
}
