package com.example.parsetogram.objects;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String Description = "description";
    public static final String Image = "image";
    public static final String User = "user";

    public String getDescription() {
        return getString(Description);
    }

    public void setDescription(String description) {
        put(Description, description);
    }

    public ParseFile getImage() {
        return getParseFile(Image);
    }

    public void setImage(ParseFile parseFile) {
        put(Image, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(User);
    }

    public void setUser(ParseUser parseUser) {
        put(User, parseUser);
    }

}
