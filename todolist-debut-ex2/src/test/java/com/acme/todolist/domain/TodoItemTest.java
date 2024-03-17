package com.acme.todolist.domain;

import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.*;

public class TodoItemTest {

    @Test
    public void doitContenirLate() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDate = now.minusHours(64);
        String contenu = "Tester TodoItem";
        Instant instantDueDate = dueDate.toInstant(ZoneOffset.UTC);
        TodoItem todoItem = new TodoItem("111111111",instantDueDate, contenu);


        String expected = "[LATE!] " + contenu;

        assertTrue(todoItem.isLate());
        assertEquals(expected, todoItem.finalContent());
    }

    @Test
    public void neDoitPasContenirLate() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDate = now.plusHours(64);
        String contenu = "Tester TodoItem";
        Instant instantDueDate = dueDate.toInstant(ZoneOffset.UTC);
        TodoItem todoItem = new TodoItem("111111111",instantDueDate, contenu);

        assertFalse(todoItem.isLate());
        assertEquals(contenu, todoItem.finalContent());
    }

}
