package com.beyt.presentation.presentation;

import com.beyt.presentation.SpringJpaDynamicQueryDemoApplication;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.model.entity.Course;
import com.beyt.presentation.repository.CourseRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import com.beyt.presentation.util.PresentationUtil;
import com.beyt.presentation.util.TestUtil;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest(classes = SpringJpaDynamicQueryDemoApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class S10_Argument_Resolvers {

    @Autowired
    private MockMvc mockMvc;

    private static final String COURSE_SEARCH_LIST_API_URL = "/test-api/course/as-list";
    private static final String COURSE_CRITERIA_API_URL = "/test-api/course";


    @PresentationMethod
    public void argumentCriteriaListTests() throws Exception {
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=name&operation0=CONTAIN&values0=Calculus", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=name&operation0=DOES_NOT_CONTAIN&values0=I", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=name&operation0=END_WITH&values0=Science", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=name&operation0=START_WITH&values0=Physics", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=active&operation0=SPECIFIED&values0=true", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=active&operation0=SPECIFIED&values0=false", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=name&operation0=EQUAL&values0=Calculus I", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=startDate&operation0=EQUAL&values0=2015-06-18", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=maxStudentCount&operation0=EQUAL&values0=54", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=name&operation0=NOT_EQUAL&values0=Introduction to Computer Science", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=id&operation0=GREATER_THAN&values0=5", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=startDate&operation0=GREATER_THAN&values0=2015-06-18", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=id&operation0=GREATER_THAN_OR_EQUAL&values0=8", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=startDate&operation0=GREATER_THAN_OR_EQUAL&values0=2019-06-18", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=maxStudentCount&operation0=LESS_THAN&values0=40", Course[].class);
        printRequestedResult(COURSE_CRITERIA_API_URL,
                "key0=maxStudentCount&operation0=LESS_THAN_OR_EQUAL&values0=40", Course[].class);
    }


    @PresentationMethod
    public void argumentSearchQueryTests() throws Exception {
        printRequestedResult(COURSE_SEARCH_LIST_API_URL,
                "select0=id&select1=username&select2=roles.id&select3=roles.name&select4=roles.roleAuthorizations.authorization.id&select5=roles.roleAuthorizations.authorization.name&select6=roles.roleAuthorizations.authorization.menuIcon&" +
                "selectAs0=adminId&selectAs1=adminUsername&selectAs2=roleId&selectAs3=roleName&selectAs4=authorizationId&selectAs5=authorizationName&selectAs6=menuIcon&" +
                        "orderBy0=roles.id&orderByDirection0=desc&" +
                        "page=1&" +
                        "pageSize=2&" +
                        "key0=roles.roleAuthorizations.authorization.menuIcon&operation0=START_WITH&values0=icon", S9_Query_Builder.AuthorizationSummary[].class);
    }

    private <T> void printRequestedResult(String apiUrl, String filter, Class<T[]> clazz) throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(apiUrl + "?" + filter))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        PresentationUtil.prettyPrint(TestUtil.getResultListValue(mvcResult.getResponse().getContentAsString(), clazz));
    }

}
