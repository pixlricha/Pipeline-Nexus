package com.example.todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TodoServiceTest {

    @Test
    public void testAddTask() {
        TodoService service = new TodoService();
        service.addTask("Learn Jenkins");
        List<String> tasks = service.getTasks();

        assertEquals(1, tasks.size());
        assertEquals("Learn Jenkins", tasks.get(0));
    }
}
