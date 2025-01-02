package com.example.introtoandroid;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> data;

    public MyCustomAdapter(Context context, List<String> data) {
        super(context, 0, data);
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        }

        String item = data.get(position);
        TextView name = listItem.findViewById(R.id.textView1);
        name.setText(item);

        return listItem;
    }
}
