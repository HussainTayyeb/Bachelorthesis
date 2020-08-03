/*

In Android an Adapter is used to fill data inside a List, i.e. our questions stack here.

This class has multiple methods to set up a list. It also holds the actual data inside a List.
List<QuestionPresenter>

 */

package com.example.studyrecommendation_app.ui.first;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.model.QuestionPresenter;

public class QuestionStackAdapter extends BaseAdapter {
    private List<QuestionPresenter> mData = new ArrayList<>();


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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent,false);
        TextView questionTextView = convertView.findViewById(R.id.textView_stack_question);
        ImageView imageViewImage = convertView.findViewById(R.id.imageView_question_image);
        QuestionPresenter item = mData.get(position);
        questionTextView.setText(item.getQuestion());
        if (item.getImageIdentifier() != null) {
            int imageIdentifier = parent
                    .getResources()
                    .getIdentifier(item.getImageIdentifier(), "drawable", parent.getContext().getPackageName());
            imageViewImage.setImageResource(imageIdentifier);
        } else {
            imageViewImage.setImageDrawable(null);
        }
        return convertView;
    }
    //
    public void addItems(List<QuestionPresenter> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

}
