package com.example.a20220203_harshraj_nycschools.ui.recylerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20220203_harshraj_nycschools.databinding.SchoolListRowBinding;
import com.example.a20220203_harshraj_nycschools.model.SchoolListData;
import com.example.a20220203_harshraj_nycschools.ui.recylerview.viewholder.SchoolListHolder;
import com.example.a20220203_harshraj_nycschools.viewmodel.SchoolListViewModel;

import java.util.List;

/**
 * Adapter class of recycler view.
 */
public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListHolder> {
    private List<SchoolListData> schoolListDataList;
    private SchoolListViewModel schoolListViewModel;

    public SchoolListAdapter(List<SchoolListData> schoolListDataList, SchoolListViewModel schoolListViewModel) {
        this.schoolListDataList = schoolListDataList;
        this.schoolListViewModel = schoolListViewModel;
    }

    /**
     * school_list_row :- Getting the binding instance to set viewmodel instance in layout.
     * @param parent
     * @param viewType
     * @return ViewHolder
     */
    @NonNull
    @Override
    public SchoolListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SchoolListRowBinding schoolListRowBinding = SchoolListRowBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        schoolListRowBinding.setSchoolListViewModel(schoolListViewModel);
        return new SchoolListHolder(schoolListRowBinding, schoolListDataList);
    }

    /**
     * Set the individual list data to show in each row.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull SchoolListHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return schoolListDataList.size();
    }
}
