package com.disasterrelief.config;

import java.time.LocalDateTime;

import com.disasterrelief.dto.*;
import com.disasterrelief.model.*;
import com.disasterrelief.repository.*;
import com.disasterrelief.service.ReliefService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedDataConfig {

    @Bean
    CommandLineRunner seedData(
            VolunteerRepository v,
            ResourceRepository r,
            ShelterRepository s,
            EmergencyRequestRepository e,
            ReliefService service) {

        return args -> {

            // Volunteers
            if (v.count() == 0) {
                service.saveVolunteer(
                        new VolunteerRequest(
                                "Priya ",
                                24,
                                Gender.FEMALE,
                                "9876543210",
                                "priya.nair@relieflink.org",
                                "Aluva",
                                "First aid, community support",
                                VolunteerStatus.AVAILABLE,
                                "9876543211"),
                        null);

                service.saveVolunteer(
                        new VolunteerRequest(
                                "Rahul ",
                                29,
                                Gender.MALE,
                                "9876543212",
                                "rahul.menon@relieflink.org",
                                "Kalamassery",
                                "Logistics, transportation",
                                VolunteerStatus.AVAILABLE,
                                "9876543213"),
                        null);

                service.saveVolunteer(
                        new VolunteerRequest(
                                "Ananya ",
                                27,
                                Gender.FEMALE,
                                "9876543214",
                                "ananya.thomas@relieflink.org",
                                "Edappally",
                                "Medical support",
                                VolunteerStatus.ASSIGNED,
                                "9876543215"),
                        null);
            }

            // Resources
            if (r.count() == 0) {
                service.saveResource(
                        new ResourceRequest(
                                "Drinking Water",
                                "Water",
                                240,
                                "bottles",
                                "Aluva Relief Center",
                                ResourceStatus.AVAILABLE),
                        null);

                service.saveResource(
                        new ResourceRequest(
                                "Rice Bags",
                                "Food",
                                85,
                                "bags",
                                "Kalamassery Storage Point",
                                ResourceStatus.AVAILABLE),
                        null);

                service.saveResource(
                        new ResourceRequest(
                                "First Aid Kits",
                                "Medical",
                                32,
                                "kits",
                                "Edappally Relief Center",
                                ResourceStatus.AVAILABLE),
                        null);
            }

            // Shelters
            if (s.count() == 0) {
                service.saveShelter(
                        new ShelterRequest(
                                "Aluva Community Hall",
                                "Aluva",
                                150,
                                112,
                                "Suresh Kumar",
                                "9876543220",
                                ShelterStatus.ACTIVE),
                        null);

                service.saveShelter(
                        new ShelterRequest(
                                "Kalamassery Government School",
                                "Kalamassery",
                                200,
                                164,
                                "Meera ",
                                "9876543221",
                                ShelterStatus.ACTIVE),
                        null);

                service.saveShelter(
                        new ShelterRequest(
                                "Edappally Relief Center",
                                "Edappally",
                                100,
                                78,
                                "Arun ",
                                "9876543222",
                                ShelterStatus.ACTIVE),
                        null);
            }

            // Emergency Requests
            if (e.count() == 0) {
                service.saveRequest(
                        new EmergencyRequestPayload(
                                "Ramesh",
                                "9876543230",
                                "Aluva",
                                "Water and food",
                                "Family of five requires drinking water and food supplies.",
                                Priority.HIGH,
                                5,
                                LocalDateTime.now(),
                                RequestStatus.PENDING),
                        null);

                service.saveRequest(
                        new EmergencyRequestPayload(
                                "Lakshmi",
                                "9876543231",
                                "Kalamassery",
                                "Medical assistance",
                                "Elderly resident requires basic medical assistance.",
                                Priority.HIGH,
                                1,
                                LocalDateTime.now(),
                                RequestStatus.PENDING),
                        null);

                service.saveRequest(
                        new EmergencyRequestPayload(
                                "Venu",
                                "9876543232",
                                "Edappally",
                                "Shelter",
                                "A group of residents requires temporary shelter.",
                                Priority.MEDIUM,
                                20,
                                LocalDateTime.now(),
                                RequestStatus.PENDING),
                        null);
            }
        };
    }
}