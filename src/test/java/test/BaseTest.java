package test;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {

    @AfterEach
    public void tearDown() {

        Driver.tearDown();
    }
}