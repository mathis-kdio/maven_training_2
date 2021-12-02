package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClassDescriptionLernejoTests {
    public static void main(String[] args) {
        TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
        List<Method> classMethods = testClassDescription.listTestMethods();
        for (Method test : classMethods) {
            System.out.println(test);
        }
    }

    @Test
    void listTestMethods() throws NoSuchMethodException {
        TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
        List<Method> listVerif = new ArrayList<>();
        SomeLernejoTests someLernejoTests = new SomeLernejoTests();
        listVerif.add(someLernejoTests.getClass().getMethod("ok"));
        listVerif.add(someLernejoTests.getClass().getMethod("ko"));
        Assertions.assertThat(testClassDescription.listTestMethods()).as("list methods of SomeLernejoTests class")
            .isEqualTo(listVerif);
    }
}
