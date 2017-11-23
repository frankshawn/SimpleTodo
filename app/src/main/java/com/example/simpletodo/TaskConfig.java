package com.example.simpletodo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niche on 2017/11/22.
 */

public class TaskConfig {
    public static List<Task> getTaskList() {
        List<Task> list = new ArrayList<Task>();
        Task task1 = new Task("用户搜索", "用户条件搜索的添加", R.drawable.task, "");
        Task task2 = new Task("案件搜索", "案件条件搜索单一值增加多选的支持", R.drawable.task, "");
        Task task3 = new Task("UI-Checkbox", "", R.drawable.task, "");
        Task task4 = new Task("UI-RadioButton", "", R.drawable.task, "");
        Task task5 = new Task("UI-Spinner", "", R.drawable.task, "");
        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);
        list.add(task5);
        return list;
    }
}
