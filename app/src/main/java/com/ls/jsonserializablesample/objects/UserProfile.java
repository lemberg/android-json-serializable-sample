package com.ls.jsonserializablesample.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vverbytskyy on 12/22/15.
 */
public class UserProfile {

    @SerializedName("username")
    private String name;

    @SerializedName("surname")
    private String surname;

    @Expose(serialize = false)
    private String nickname;

    @SerializedName("age")
    private int age;

    @Expose(deserialize = false)
    private boolean married = false;

    public UserProfile(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserProfile { " +
                "name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", nickname ='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfile profile = (UserProfile) o;

        if (age != profile.age) return false;
        if (married != profile.married) return false;
        if (name != null ? !name.equals(profile.name) : profile.name != null) return false;
        if (surname != null ? !surname.equals(profile.surname) : profile.surname != null)
            return false;
        return !(nickname != null ? !nickname.equals(profile.nickname) : profile.nickname != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (married ? 1 : 0);
        return result;
    }
}
