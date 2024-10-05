package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {
    @BeforeAll
    public static void setUp() {
    }
    @AfterAll
    public static void tearDown() {

    }
    @Before
    public void beforeTest() {
        startDriver();
    }
    @After
    public void afterTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        quitDriver();
    }
}
