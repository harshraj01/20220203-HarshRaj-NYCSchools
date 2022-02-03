package com.example.a20220203_harshraj_nycschools.ui.recylerview.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Base class for recycler view holder.
 */
public abstract class BaseListHolder extends RecyclerView.ViewHolder {
    public BaseListHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
