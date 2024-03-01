package com.beyt.presentation.annotation;


import com.beyt.presentation.SpringJpaDynamicQueryDemoApplication;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Service
@SpringBootTest(classes = SpringJpaDynamicQueryDemoApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public @interface PresentationService {
}
