package dev.supervisorback.controller;

import dev.supervisorback.dto.NotificationDto;
import dev.supervisorback.dto.SupervisorDto;
import dev.supervisorback.service.SupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supervisors")
@CrossOrigin
public class SupervisorController {

	final SupService service;

	@GetMapping
	public List<SupervisorDto> getSupervisors() {
		return service.getFilteredSups();
	}

	@PostMapping("/notify")
	public ResponseEntity<String> sendNotification(@RequestBody @Valid NotificationDto request) {
		service.sendNotification(request);
		return ResponseEntity.ok("Notification request received.");
	}


}
