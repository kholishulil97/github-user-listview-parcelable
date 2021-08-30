package com.example.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {
    TextView tvName, tvUsername, tvFollowing, tvFollowers, tvRepository, tvLocation, tvCompany;
    ImageView ivAvatar;
    Button btPortofolio, btDial;

    public static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        tvName = findViewById(R.id.tv_name);
        tvUsername = findViewById(R.id.tv_username);
        tvFollowing = findViewById(R.id.tv_following);
        tvFollowers = findViewById(R.id.tv_followers);
        tvRepository = findViewById(R.id.tv_repository);
        tvLocation = findViewById(R.id.tv_location);
        tvCompany = findViewById(R.id.tv_company);
        ivAvatar = findViewById(R.id.iv_avatar);
        btPortofolio = findViewById(R.id.bt_porto);
        btDial = findViewById(R.id.bt_call);

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        String textName = user.getName();
        String textUserName = user.getUsername();
        String textLocation = user.getLocation();
        String textCompany = user.getCompany();
        int avatar = user.getAvatar();
        int intRepository = user.getRepository();
        int intFollowing = user.getFollowing();
        int intFollowers = user.getFollower();

        tvName.setText(textName);
        tvUsername.setText(textUserName);
        tvLocation.setText(textLocation);
        tvCompany.setText(textCompany);
        tvRepository.setText(String.valueOf(intRepository));
        tvFollowing.setText(String.valueOf(intFollowing));
        tvFollowers.setText(String.valueOf(intFollowers));
        ivAvatar.setImageResource(avatar);

        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "081210841382";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
            }
        });

        btPortofolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com"));
                startActivity(browserIntent);
            }
        });
    }
}
