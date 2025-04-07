package dev.supervisorback.service;

import dev.supervisorback.dto.NotificationDto;
import dev.supervisorback.dto.SupervisorDto;

import java.util.List;

public interface SupService {
	List<SupervisorDto> getFilteredSups();

	void sendNotification(NotificationDto notificationDto);


}
