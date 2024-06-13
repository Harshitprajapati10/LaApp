package com.example.hla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Customtopicadapter extends ArrayAdapter<String> {

    private Context context;
    private String[] topics;
    private int[] imageResourceIds;

    public Customtopicadapter(Context context, String[] topics, String[] imageResourceNames) {
        super(context, R.layout.customlayout, topics);
        this.context = context;
        this.topics = topics;
        this.imageResourceIds = new int[topics.length];

         //Convert image resource names to resource IDs (optional)
        for (int i = 0; i < imageResourceNames.length; i++) {
            int resourceId = context.getResources().getIdentifier(imageResourceNames[i], "drawable", context.getPackageName());
            imageResourceIds[i] = resourceId;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.customlayout, parent, false); // Replace with your layout resource id

        TextView topicText = itemView.findViewById(R.id.topic_text);
        ImageView topicIcon = itemView.findViewById(R.id.topic_icon);

        topicText.setText(topics[position]);

        // Set icon based on position
        topicIcon.setImageResource(imageResourceIds[position]);

        return itemView;
    }
}

