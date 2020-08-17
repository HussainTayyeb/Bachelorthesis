package com.example.studyrecommendation_app.ui.third;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyrecommendation_app.R;

public class UniversityItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int spacing = view.getResources().getDimensionPixelSize(R.dimen.space_universityItem);
        outRect.top = spacing;
        outRect.bottom = spacing;
    }

}

