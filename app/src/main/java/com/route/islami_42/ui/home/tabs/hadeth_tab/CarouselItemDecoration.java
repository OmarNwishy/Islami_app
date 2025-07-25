package com.route.islami_42.ui.home.tabs.hadeth_tab;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class CarouselItemDecoration extends RecyclerView.ItemDecoration {
    private final int margin;

    public CarouselItemDecoration(int margin) {
        this.margin = margin; // Margin in pixels
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        // Add margin to the left of all items except the first one
        if (position != 0) {
            outRect.left = margin;
        }
        // Add margin to the right of all items except the last one
        if (position != parent.getAdapter().getItemCount() - 1) {
            outRect.right = margin;
        }
    }
}