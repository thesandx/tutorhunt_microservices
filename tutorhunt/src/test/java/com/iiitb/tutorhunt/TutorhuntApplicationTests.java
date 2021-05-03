package com.iiitb.tutorhunt;

import com.iiitb.tutorhunt.Controller.CourseController;
import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Services.courseregservice;
import com.iiitb.tutorhunt.Services.tutorRegservice;
import com.iiitb.tutorhunt.payloads.courserequest;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class)
class TutorhuntApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @AutoConfigureMockMvc(addFilters = false)
    @Before()
    public void setup()
    {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @MockBean
    courseregservice courseregservice;

    @MockBean
    tutorRegservice tutorservice;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    courserequest course = new courserequest("Theoritical Physics","Higher School Physics");
    List<String> result=new ArrayList<>();
    @Test
    @WithMockUser(username="admin",roles="ADMIN")
    public void getAllCourses() throws Exception {
                when(courseregservice.getAllCourses()).thenReturn(result);
                mockMvc.perform( MockMvcRequestBuilders
                .get("/Course/getAllCourses")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    boolean res;
    @Test
    @WithMockUser(username="admin",roles="ADMIN")
    public void registerCourse() throws Exception {
        //when(courseregservice.registerCourse(Mockito.any(Course.class))).thenReturn(res);
        mockMvc.perform( MockMvcRequestBuilders
                .post("/Course/courses")
                .content(asJsonString(course))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .with(csrf()))
                .andExpect(status().isOk());
    }


}
