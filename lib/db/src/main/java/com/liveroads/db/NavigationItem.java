package com.liveroads.db;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liveroads on 29/08/17.
 */

@IgnoreExtraProperties
public class NavigationItem {
    // TODO: add new fields
    // time stamps,
    // created,
    // last accessed,
    // number of times accessed

    public String location;

    public NavigationItem() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public NavigationItem(String location) {
        this.location = location;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("location", location);

        return result;
    }

}
