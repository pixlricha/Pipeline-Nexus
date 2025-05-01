package com.example.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}
