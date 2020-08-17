package com.example.studyrecommendation_app.ui.third;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.model.UniversityPresenter;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder> {
    private ArrayList<UniversityPresenter> mUniversities = new ArrayList<>();


    @NonNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_university, parent, false);
        return new UniversityViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityViewHolder holder, int position) {
        holder.bind(mUniversities.get(position));
    }

    @Override
    public int getItemCount() {
        return mUniversities.size();
    }

    public void addItems(List<UniversityPresenter> items) {
        int startIndex = mUniversities.size();
        mUniversities.addAll(items);
        notifyItemRangeInserted(startIndex, items.size());
    }


    static class UniversityViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageView imageImageView;


        public UniversityViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textView_university_name);
            imageImageView = itemView.findViewById(R.id.imageView_university_image);
        }


        void bind(UniversityPresenter item) {
            nameTextView.setText(item.getName());

            if (item.getImageIdentifier() != null) {
                int imageResId = itemView.getResources().getIdentifier(
                        item.getImageIdentifier(),
                        "drawable",
                        itemView.getContext().getPackageName());
                imageImageView.setImageResource(imageResId);
            } else {
                imageImageView.setImageDrawable(null);
            }

        }

    }
}
