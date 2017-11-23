package com.example.simpletodo;

/**
 * Created by niche on 2017/11/22.
 */

public class Task {
    public String title = "";
    public String desc = "";
    public int icon;
    public String finishedMemo = "";

    public Task() {
    }

    public Task(String title, String desc, int icon, String finishedMemo) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;
        this.finishedMemo = finishedMemo;
    }
}
