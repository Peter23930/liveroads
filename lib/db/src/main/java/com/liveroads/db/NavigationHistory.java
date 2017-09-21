package com.liveroads.db;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liveroads on 29/08/17.
 */

public class NavigationHistory implements ValueEventListener{
    final static String dbname = "navigation-history";

    ArrayList<String> history = new ArrayList<>();

    DatabaseReference database;
    String uid;

    public NavigationHistory(FirebaseDatabase db, String uid) {
        this.uid = uid;
        this.database = db.getReference(dbname);

        Query userHistory = database.child(uid);
        userHistory.addValueEventListener(this);
    }

    public void addRecord(String location){
        String key = database.child(dbname).push().getKey();
        NavigationItem hp = new NavigationItem(location);

        Map<String, Object> postValues = hp.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/" + uid + "/" + key, postValues);

        database.updateChildren(childUpdates);
    }

    public ArrayList<String> getHistory(){
        return this.history;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            history.clear();
            for (DataSnapshot record : dataSnapshot.getChildren()) {
                NavigationItem item = record.getValue(NavigationItem.class);
                Log.i("LR", ":::" + item.location);
                history.add(item.location);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {
        Log.w("LR", "Failed to read value.", error.toException());
    }
}
