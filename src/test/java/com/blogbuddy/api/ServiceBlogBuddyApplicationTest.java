package com.blogbuddy.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class ServiceBlogBuddyApplicationTest extends AbstractUnitTest {

    @Test
    public void contextLoads() {
        // TODO: after you create your first controller test class, please delete
        // this one
        // yOU can't have a test statement without body
    }

    @Test
    public void applicationRequiredConfiguration() {

        // Arrange

        // Act
        boolean actual = ServiceBlogBuddyApplication.class.isAnnotationPresent(SpringBootApplication.class);

        // Assert
        // TODO: Remove below asserts as necessary according to application dependencies
        Assertions.assertTrue(actual, "Should be a SpringBootApplication");
    }
}
