package com.example.parsetogram.fragments;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.parsetogram.objects.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment {

    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);

        query.include(Post.User);
        query.setLimit(20);
        query.whereEqualTo(Post.User, ParseUser.getCurrentUser());
        query.addDescendingOrder(Post.CreatedAt);
        query.findInBackground(new FindCallback<Post>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Something in this query has gone wrong", e);
                    return;
                }
                for(Post post : objects) {
                    Log.i(TAG, "Posts: " + post.getDescription() + " username: " + post.getUser().getUsername());
                }
                allPosts.addAll(objects);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
