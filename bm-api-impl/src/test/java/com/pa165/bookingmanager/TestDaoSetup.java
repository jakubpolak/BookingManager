package com.pa165.bookingmanager;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jakub Polak
 */
@ContextConfiguration(locations={
    "classpath:/configuration/testing/spring.xml",
    "classpath:/configuration/testing/hibernate.xml"
})
@TransactionConfiguration
@Transactional
public class TestDaoSetup
{

}
