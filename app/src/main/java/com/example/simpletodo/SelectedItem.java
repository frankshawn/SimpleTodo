package com.example.simpletodo;

/**
 * Created by niche on 2017/11/23.
 */
public class SelectedItem {
    int position;
    boolean checked;

    public SelectedItem(int position, boolean checked) {
        this.position = position;
        this.checked = checked;
    }

    public int getPosition() {
        return position;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}