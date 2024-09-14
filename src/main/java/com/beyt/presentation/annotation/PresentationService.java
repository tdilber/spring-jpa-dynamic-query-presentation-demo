package com.beyt.presentation.annotation;


import com.beyt.presentation.SpringJpaDynamicQueryDemoApplication;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Service
@SpringBootTest(classes = SpringJpaDynamicQueryDemoApplication.class, properties = "spring.sql.init.mode=never")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public @interface PresentationService {
}
