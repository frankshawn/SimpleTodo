package com.example.simpletodo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by niche on 2017/11/21.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<Task> values;
    public List<SelectedItem> selectItems = new ArrayList<SelectedItem>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public TextView txtDesc;
        public ImageView imgIcon;
        public CheckBox mCheckBox;
        public View listItemView;

        public ViewHolder(View v) {
            super(v);
            listItemView = v;
            txtTitle = (TextView) v.findViewById(R.id.txt_title);
            txtDesc = (TextView) v.findViewById(R.id.txt_desc);
            imgIcon = (ImageView) v.findViewById(R.id.img_icon);
            mCheckBox = (CheckBox) v.findViewById(R.id.checkbox);
        }
    }

    public void add(int position, Task task) {
        values.add(position, task);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MainAdapter(List<Task> dataList) {
        values = dataList;
        initSelectItems();
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.active_main_lv_item, parent, false);
        return new ViewHolder(v);
    }

    public void initSelectItems() {
        int position = 0;
        while (position < getItemCount()) {
            selectItems.add(new SelectedItem(position, false));
            position++;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Task task = values.get(position);
        holder.txtTitle.setText(task.title);
        holder.listItemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), TaskDetailsActivity.class);
                        view.getContext().startActivity(intent);
                    }
                }
        );
        holder.txtDesc.setText(task.desc);
        holder.imgIcon.setImageResource(task.icon);
        holder.mCheckBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        compoundButton.setChecked(b);
                        selectItems.get(position).setChecked(b);
                        StringBuffer tips = new StringBuffer();
                        for (SelectedItem selectedItem: getSelectedItems()) {
                            tips.append(selectedItem.getPosition() + ",");
                        }
                        Toast.makeText(compoundButton.getContext(), tips.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public List<SelectedItem> getSelectedItems() {
        List<SelectedItem> result = new ArrayList<SelectedItem>();
        Iterator iterator = this.selectItems.iterator();
        while (iterator.hasNext()) {
            SelectedItem selectedItem = (SelectedItem) iterator.next();
            if (selectedItem.isChecked()) {
                result.add(selectedItem);
            }
        }
        return result;
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
