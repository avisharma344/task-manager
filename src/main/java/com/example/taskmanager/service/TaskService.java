package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequestDto;
import com.example.taskmanager.dto.TaskResponseDto;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskStatus;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Constructor Injection (BEST PRACTICE)
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // ✅ CREATE TASK
    public TaskResponseDto createTask(TaskRequestDto requestDto) {

        Task task = new Task();
        task.setTitle(requestDto.getTitle());
        task.setDescription(requestDto.getDescription());
        task.setStatus(
                requestDto.getStatus() != null
                        ? requestDto.getStatus()
                        : TaskStatus.PENDING
        );
        task.setCreatedAt(LocalDateTime.now());

        Task savedTask = taskRepository.save(task);
        return mapToResponseDto(savedTask);
    }
    public Page<TaskResponseDto> getTasksWithPagination(
            int page,
            int size,
            String sortBy,
            String sortDir
    ) {

        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Task> taskPage = taskRepository.findAll(pageable);

        return taskPage.map(this::mapToResponseDto);
    }


    // ✅ GET ALL TASKS
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    // ✅ GET TASK BY ID
    public TaskResponseDto getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found with id: " + id)
                );

        return mapToResponseDto(task);
    }

    // ✅ UPDATE TASK
    public TaskResponseDto updateTask(Long id, TaskRequestDto requestDto) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found with id: " + id)
                );

        task.setTitle(requestDto.getTitle());
        task.setDescription(requestDto.getDescription());
        task.setStatus(requestDto.getStatus());

        Task updatedTask = taskRepository.save(task);
        return mapToResponseDto(updatedTask);
    }

    // ✅ DELETE TASK
    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found with id: " + id)
                );

        taskRepository.delete(task);
    }

    // 🔁 ENTITY → DTO MAPPER
    private TaskResponseDto mapToResponseDto(Task task) {

        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setCreatedAt(task.getCreatedAt());

        return dto;
    }
}
