package dev.supervisorback.service;

import dev.supervisorback.dto.NotificationDto;
import dev.supervisorback.dto.SupervisorDto;
import dev.supervisorback.model.Supervisor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SupServiceImpl implements SupService {
    final RestTemplate restTemplate = new RestTemplate();

    final ModelMapper modelMapper;

    @Override
    public List<SupervisorDto> getFilteredSups() {
        String url = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
        Supervisor[] supervisors = restTemplate.getForObject(url, Supervisor[].class);

        return Arrays.stream(Objects.requireNonNull(supervisors))
                .filter(s ->
                        s.getJurisdiction() != null &&
                                !s.getJurisdiction().trim().isEmpty() &&
                                !s.getJurisdiction().matches("\\d+"))
                .sorted(Comparator
                        .comparing(Supervisor::getFirstName)
                        .thenComparing(Supervisor::getLastName)
                        .thenComparing(Supervisor::getJurisdiction))
                .map(s -> modelMapper.map(s, SupervisorDto.class))
                .toList();
    }

    @Override
    public void sendNotification(NotificationDto not) {
        System.out.println(
                "First name: " + not.getFirstName() + "\n" +
                        "Last name: " + not.getLastName() + "\n" +
                        "Email: " + not.getEmail()
        );
    }
}
