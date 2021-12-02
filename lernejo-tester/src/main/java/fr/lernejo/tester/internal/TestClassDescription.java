package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    private final Class<?> className;
    public TestClassDescription(Class<?> className) {
        this.className = className;
    }

    public List<Method> listTestMethods() {
        Method[] classMethods = this.className.getDeclaredMethods();
        List<Method> listMethods = new ArrayList<>();
        for (Method method : classMethods) {
            if (Modifier.isPublic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameters().length == 0 && method.getAnnotation(TestMethod.class) != null) {
                listMethods.add(method);
            }
        }
        return listMethods;
    }

}
