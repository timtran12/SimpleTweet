package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfileImage1;
    TextView tvName;
    TextView tvScreenName;
    TextView tvBody;
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvBody = findViewById(R.id.tvBody);
        tvTime = findViewById(R.id.tvTime);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        Glide.with(this).load(tweet.user.publicImageURL).into(ivProfileImage1);
        tvName.setText(tweet.user.name);
        tvScreenName.setText("@"+tweet.user.screenName);
        tvBody.setText(tweet.body);
        tvTime.setText(tweet.getRelativeTime(tweet.createdAt));

    }
}