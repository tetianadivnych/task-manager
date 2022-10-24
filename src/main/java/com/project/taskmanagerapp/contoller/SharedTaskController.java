package com.project.taskmanagerapp.contoller;

import com.project.taskmanagerapp.model.SharedTaskRequest;
import com.project.taskmanagerapp.service.SharedTaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SharedTaskController {
private final SharedTaskService sharedTaskService;

    public SharedTaskController(SharedTaskService sharedTaskService) {
        this.sharedTaskService = sharedTaskService;
    }

    @PostMapping("/shared-tasks")
    public void shareTask(@RequestBody SharedTaskRequest sharedTaskRequest) {
        sharedTaskService.shareTask(sharedTaskRequest);
    }
}
