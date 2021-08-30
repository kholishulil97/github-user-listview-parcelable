package com.example.githubuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> user = new ArrayList<>();

    public UserAdapter(Context context) {
        this.context = context;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int i) {
        return user.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User) getItem(i);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtUserName;
        private ImageView imgAvatar;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtUserName = view.findViewById(R.id.txt_username);
            imgAvatar = view.findViewById(R.id.img_avatar);
        }
        void bind(User user) {
            txtName.setText(user.getName());
            txtUserName.setText(user.getUsername());
            imgAvatar.setImageResource(user.getAvatar());
        }
    }
}
