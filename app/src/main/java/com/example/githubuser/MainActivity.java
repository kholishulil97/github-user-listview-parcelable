package com.example.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private UserAdapter adapter;
    private String[] dataName, dataUserName, dataLocation, dataCompany, dataFollowing, dataFollower, dataRepository;
    private TypedArray dataAvatar;
    private ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = userArrayList.get(i);
                Intent moveWithObjectIntent = new Intent(MainActivity.this, UserProfileActivity.class);
                moveWithObjectIntent.putExtra(UserProfileActivity.EXTRA_USER, user);
                startActivity(moveWithObjectIntent);
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataUserName = getResources().getStringArray(R.array.username);
        dataCompany = getResources().getStringArray(R.array.company);
        dataLocation = getResources().getStringArray(R.array.location);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        dataRepository = getResources().getStringArray(R.array.repository);
        dataFollower = getResources().getStringArray(R.array.followers);
        dataFollowing = getResources().getStringArray(R.array.following);
    }

    private void addItem() {
        userArrayList = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            User user1 = new User();
            user1.setAvatar(dataAvatar.getResourceId(i, -1));
            user1.setName(dataName[i]);
            user1.setUsername(dataUserName[i]);
            user1.setLocation(dataLocation[i]);
            user1.setCompany(dataCompany[i]);
            user1.setRepository(Integer.valueOf(dataRepository[i]));
            user1.setFollowing(Integer.valueOf(dataFollowing[i]));
            user1.setFollower(Integer.valueOf(dataFollower[i]));
            userArrayList.add(user1);
        }
        adapter.setUser(userArrayList);
    }
}
