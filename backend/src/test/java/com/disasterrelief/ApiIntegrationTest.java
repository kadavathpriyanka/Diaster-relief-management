package com.disasterrelief;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiIntegrationTest {
 @Autowired MockMvc mvc;
 @Test void health() throws Exception {mvc.perform(get("/api/health")).andExpect(status().isOk()).andExpect(jsonPath("$.status").value("success"));}
 @Test void createsVolunteer() throws Exception {mvc.perform(post("/api/volunteers").contentType(MediaType.APPLICATION_JSON).content("{\"fullName\":\"Test Volunteer\",\"age\":30,\"gender\":\"MALE\",\"phone\":\"555-1000\",\"email\":\"test.volunteer@example.org\",\"address\":\"1 Test Street\",\"skills\":\"Rescue\",\"availability\":\"AVAILABLE\",\"emergencyContact\":\"555-1009\"}")).andExpect(status().isCreated()).andExpect(jsonPath("$.fullName").value("Test Volunteer"));}
 @Test void createsResource() throws Exception {mvc.perform(post("/api/resources").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Blankets\",\"category\":\"Supplies\",\"quantity\":10,\"unit\":\"items\",\"location\":\"Depot\",\"status\":\"AVAILABLE\"}")).andExpect(status().isCreated()).andExpect(jsonPath("$.name").value("Blankets"));}
 @Test void createsShelter() throws Exception {mvc.perform(post("/api/shelters").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Test Shelter\",\"location\":\"1 Safe Road\",\"capacity\":50,\"currentOccupancy\":5,\"contactPerson\":\"Sam\",\"contactNumber\":\"555-1001\",\"status\":\"ACTIVE\"}")).andExpect(status().isCreated()).andExpect(jsonPath("$.availableSpaces").value(45));}
 @Test void createsEmergencyRequest() throws Exception {mvc.perform(post("/api/requests").contentType(MediaType.APPLICATION_JSON).content("{\"requesterName\":\"Test Caller\",\"contactNumber\":\"555-1002\",\"location\":\"North District\",\"requestType\":\"Medical\",\"description\":\"Needs assistance\",\"priority\":\"HIGH\",\"peopleAffected\":3,\"requestDateTime\":\"2026-09-18T10:00:00\",\"status\":\"PENDING\"}")).andExpect(status().isCreated()).andExpect(jsonPath("$.status").value("PENDING"));}
 @Test void readsDashboardStats() throws Exception {mvc.perform(get("/api/dashboard/stats")).andExpect(status().isOk()).andExpect(jsonPath("$.totalVolunteers").isNumber()).andExpect(jsonPath("$.availableShelterSpaces").isNumber());}
}
