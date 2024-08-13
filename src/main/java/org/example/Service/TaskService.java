package org.example.Service;



import org.example.entity.Task;
import org.example.entity.User;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repository.TaskRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(Task task, String timeZone) {
        User assignedUser = userRepository.findById(task.getAssignedTo().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ZoneId zoneId = timeZone != null ? ZoneId.of(timeZone) : ZoneId.of(assignedUser.getTimeZone());
        OffsetDateTime now = OffsetDateTime.now(zoneId).withOffsetSameInstant(ZoneOffset.UTC);

        task.setCreatedAt(now);
        task.setUpdatedAt(now);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public Task updateTask(Long id, Task taskDetails, String timeZone) {
        Task task = getTaskById(id);
        User assignedUser = userRepository.findById(taskDetails.getAssignedTo().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setAssignedTo(assignedUser);

        ZoneId zoneId = timeZone != null ? ZoneId.of(timeZone) : ZoneId.of(assignedUser.getTimeZone());
        task.setUpdatedAt(OffsetDateTime.now(zoneId).withOffsetSameInstant(ZoneOffset.UTC));

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }
}
