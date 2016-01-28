package com.ls.jsonserializablesample;

import android.test.InstrumentationTestCase;

import com.ls.jsonserializablesample.objects.UserProfile;
import com.ls.utils.jsonserializable.JsonSerializable;

import net.javacrumbs.jsonunit.JsonAssert;

import java.util.List;
import java.util.Map;

/**
 * Created by vverbytskyy on 1/28/16.
 */
public class JsonSerializableTest extends InstrumentationTestCase {

    private Utils utils;

    private static final String JSON_READING_EXPECTED = "{\"field1\":1,\"field2\":1.0,\"field3\":true,\"field4\":\"test\",\"field5\":{\"key1\":\"test\",\"key2\":\"test\",\"key3\":\"test\"}}";

    @Override
    public void setUp() throws Exception {
        super.setUp();

        utils = new Utils(getInstrumentation().getContext());
    }

    @Override
    public void tearDown() throws Exception {
        utils = null;

        super.tearDown();
    }


    public void testJsonReadingFromAssets() {

        String actualJson = utils.loadJsonFromAsset("json_for_reading.json");

        JsonAssert.assertJsonStructureEquals(JSON_READING_EXPECTED, actualJson);
        JsonAssert.assertJsonEquals(JSON_READING_EXPECTED, actualJson);
    }


    public void testObjectsFromJsonEquals() {

        UserProfile expectedProfile = utils.getUserProfile();
        UserProfile actualProfile = JsonSerializable.fromJsonUnsafe(UserProfile.class, utils.loadJsonFromAsset("user_profile.json"));

        assertEquals(expectedProfile, actualProfile);
    }

    public void testListEqualsFromJson() {

        List<UserProfile> expectedList = utils.getUserProfileList();
        List<UserProfile> actualList = JsonSerializable.toList(utils.loadJsonFromAsset("user_profile_array.json"), UserProfile.class);

        assertEquals(expectedList, actualList);
    }

    public void testMapsEqualsFromJson() {

        Map<String, UserProfile> expectedMap = utils.getUserProfileMap();
        Map<String, UserProfile> actualMap = JsonSerializable.toMap(utils.loadJsonFromAsset("user_profile_map.json"), String.class, UserProfile.class);

        assertEquals(expectedMap, actualMap);
    }

    public void testJsonEquals_objects() {

        String expectedJson = utils.loadJsonFromAsset("user_profile.json");

        UserProfile profile = utils.getUserProfile();
        profile.setMarried(true);

        String actualJson = JsonSerializable.toJson(profile);

        JsonAssert.assertJsonStructureEquals(expectedJson, actualJson);
        JsonAssert.assertJsonEquals(expectedJson, actualJson);
    }

    public void testJsonEquals_list() {

        String expectedJson = utils.loadJsonFromAsset("user_profile_array.json");
        String actualJson = JsonSerializable.toJson(utils.getUserProfileList());

        JsonAssert.assertJsonStructureEquals(expectedJson, actualJson);
        JsonAssert.assertJsonEquals(expectedJson, actualJson);
    }

    public void testJsonEquals_map() {

        String expectedJson = utils.loadJsonFromAsset("user_profile_map.json");
        String actualJson = JsonSerializable.toJson(utils.getUserProfileMap());

        JsonAssert.assertJsonStructureEquals(expectedJson, actualJson);
        JsonAssert.assertJsonEquals(expectedJson, actualJson);
    }

    public void testExposeAnnotation_serialize() {

        UserProfile profile = utils.getUserProfile();
        profile.setNickname("test-nickname");
        profile.setMarried(true);

        String expectedJson = utils.loadJsonFromAsset("user_profile.json");
        String actualJson = JsonSerializable.toJson(profile);

        JsonAssert.assertJsonStructureEquals(expectedJson, actualJson);
        JsonAssert.assertJsonEquals(expectedJson, actualJson);
    }

    public void testExposeAnnotation_deserialize() {

        UserProfile expectedProfile = utils.getUserProfile();
        UserProfile actualProfile = JsonSerializable.fromJsonUnsafe(UserProfile.class, utils.loadJsonFromAsset("user_profile.json"));

        assertEquals(expectedProfile, actualProfile);
    }

    public void testCorruptedJson() {

        UserProfile expectedProfile = utils.getUserProfile();
        UserProfile actualProfile = JsonSerializable.fromJsonUnsafe(UserProfile.class, utils.loadJsonFromAsset("user_profile_wrong.json"));

        assertEquals(expectedProfile, actualProfile);
    }
}
