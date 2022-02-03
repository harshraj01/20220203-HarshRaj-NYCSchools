package com.example.a20220203_harshraj_nycschools.ui.recylerview.viewholder;

import androidx.annotation.NonNull;

import com.example.a20220203_harshraj_nycschools.databinding.SchoolListRowBinding;
import com.example.a20220203_harshraj_nycschools.model.SchoolListData;
import com.example.a20220203_harshraj_nycschools.model.SchoolListModel;
import com.example.a20220203_harshraj_nycschools.ui.recylerview.base.BaseListHolder;

import java.util.List;

/**
 * ViewHolder class for recylcer view.
 */
public class SchoolListHolder extends BaseListHolder {

    private SchoolListRowBinding mBinding;
    private List<SchoolListData> schoolListData;

    public SchoolListHolder(@NonNull SchoolListRowBinding binding,
                            List<SchoolListData> schoolListData) {
        super(binding.getRoot());
        this.mBinding = binding;
        this.schoolListData = schoolListData;
    }

    /**
     * This method is called from adapter class onBindViewHolder to show data on each row based on position.
     * @param position
     */
    @Override
    public void onBind(int position) {
        SchoolListData schoolData = schoolListData.get(position);
        mBinding.setSchoolListModel(new SchoolListModel(schoolData.getFullName()));
        mBinding.viewForeground.setTag(position);
        mBinding.executePendingBindings();
    }
}
