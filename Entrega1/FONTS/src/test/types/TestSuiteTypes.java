package test.types;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)

@SuiteClasses(value = {
        TestPairFrequency.class, TestPairInt.class
})

public class TestSuiteTypes {}