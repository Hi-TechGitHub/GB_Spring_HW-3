package com.example.example3.other;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Task {
    private final UUID id;
    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private Status status;
    @Setter
    private LocalDateTime completionTime;

    public Task(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.status = Status.TO_DO;
    }

    private enum Status{
        TO_DO,
        IN_PROGRESS,
        DONE
    }
}