# android-json-serializable-sample

**What is it?**

JsonSerializable it's a simple library based on Gson that allows to serialize/deserialize objects,
Lists of objects, Maps of objects, etc.

**Getting started**

1. Checkout library project from [there](https://lemberg.codebasehq.com/projects/lemberg-internal-android/repositories/json-serializable/tree/dev).
2. Open project's root folder using terminal (*nix-based OS) or CMD (Windows family).
3. Use `mvn package` command to build jar library.
4. After packaging, copy *jsonsserializable.jar*  into `<project path>/<project name>/app/libs/` folder.
5. Rebuild your project.

**Using JsonSerializable**

* Simple objects example:
```java

        String name = "TestName";
        String surname = "TestSurname";
        int age = 20;

        //Creating object for serialization
        UserProfile profile = new UserProfile(name, surname, age);
        
        //Object serialization
        String jsonProfile = JsonSerializable.toJson(profile);

        //Object deserialization
        UserProfile userProfileFromJson = JsonSerializable.fromJsonUnsafe(UserProfile.class, jsonProfile);

```

* List of objects
```java

        String name = "TestName";
        String surname = "TestSurname";
        int age = 20;

        //Creating list of objects
        List<UserProfile> userProfileList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {

            String tmpName = name + i;
            String tmpSurname = name + i;
            int tmpAge = age + i;


            userProfileList.add(new UserProfile(tmpName, tmpSurname, tmpAge));
        }

        //List serialization
        String jsonProfiles = JsonSerializable.toJson(userProfileList);

        //List deserialization
        List<UserProfile> userProfileListFromJson = JsonSerializable.toList(jsonProfiles, UserProfile.class);

```

* Map of objects
```java

        String name = "TestName";
        String surname = "TestSurname";
        int age = 20;


        List<UserProfile> userProfileList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {

            String tmpName = name + i;
            String tmpSurname = name + i;
            int tmpAge = age + i;


            userProfileList.add(new UserProfile(tmpName, tmpSurname, tmpAge));
        }

        //Creating map of objects
        Map<Integer, UserProfile> userProfileMap = new HashMap<>();
        int i = 0;
        for (UserProfile profileItem : userProfileList) {
            userProfileMap.put(i, profileItem);
            i++;
        }

        //Map serialization
        String jsonMapProfiles = JsonSerializable.toJson(userProfileMap);

        //Map deserialization
        Map<Integer, UserProfile> userProfileMapFromJson = JsonSerializable.toMap(jsonMapProfiles, Integer.class, UserProfile.class);


```

**License**

```
The MIT License (MIT)

Copyright (c) 2015 Lemberg Solutions

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```