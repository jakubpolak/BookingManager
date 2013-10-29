package com.pa165.bookingmanager;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Jakub Polak
 */
@ContextConfiguration(locations={
    "classpath:/configuration/testing/spring.xml"
})
public class TestServiceSetup
{
    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
