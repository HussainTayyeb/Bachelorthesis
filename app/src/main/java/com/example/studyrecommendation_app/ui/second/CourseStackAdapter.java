package com.example.studyrecommendation_app.ui.second;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.model.CourseLocal;
import com.example.studyrecommendation_app.data.model.CoursePresenter;

public class CourseStackAdapter extends BaseAdapter {
    private List<CoursePresenter> mData = new ArrayList<>();


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent,false);
        ImageView imageImageView = convertView.findViewById(R.id.imageView_course_image);
        TextView courseTextView = convertView.findViewById(R.id.textView_stack_course);
        TextView universityNameTextView = convertView.findViewById(R.id.textView_stack_universityName);
        TextView descriptionTextView = convertView.findViewById(R.id.textView_stack_description);
        CoursePresenter item = mData.get(position);
        courseTextView.setText(item.getCourse());
        universityNameTextView.setText(item.getUniversityName());
        descriptionTextView.setText(item.getDescription());

        if (item.getImageIdentifier() != null) {
            int imageIdentifier = parent
                    .getResources()
                    .getIdentifier(item.getImageIdentifier(), "drawable", parent.getContext().getPackageName());
            imageImageView.setImageResource(imageIdentifier);
        } else {
            imageImageView.setImageDrawable(null);
        }

        return convertView;
    }

    public void addItems(List<CoursePresenter> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

}