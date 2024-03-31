package org.arunav.java.reflection;

import java.lang.reflect.*;

/*
* As this project is using annotations from the _7_annotations project. So after building the _7_annotations project then compile this project using the following command -
*
*  javac -d classes -processorpath {path}/exploring-java/_7_annotations/target/_7_annotations-1.0-SNAPSHOT.jar -processor org.arunav.java.annotation.processor.WorkProcessor -classpath {path}/exploring-java/_7_annotations/target/_7_annotations-1.0-SNAPSHOT.jar {path}/exploring-java/_6_reflection/src/main/java/org/arunav/java/reflection/*.java

Replace {path} with the absolute path where exploring-java is in your system

 */


public class Main {

    public static void main(String args[]) throws InvocationTargetException, IllegalAccessException {
        Fruit fruit = new Fruit("Mango", "Yellow");

        // Get the list of fields in Fruit class
        Field[] declaredFields = fruit.getClass().getDeclaredFields();
        for(Field field : declaredFields){
            System.out.println(field);
        }

        // Getting the list of methods in Fruit class
        Method[] declaredMethods = fruit.getClass().getDeclaredMethods();
        for(Method method : declaredMethods) {
            System.out.println(method);

            // Executing a private method using reflection
            if(Modifier.isPrivate(method.getModifiers())){
                method.setAccessible(true);
                Parameter[] parameters = method.getParameters();
                for(Parameter parameter : parameters)
                    System.out.println(parameter);
                method.invoke(fruit, fruit, null);
            }
        }
    }
}
