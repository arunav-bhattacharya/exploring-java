package org.arunav.java.reflection;

import org.arunav.java.annotation.processor.WorkProcessor;

import java.lang.reflect.*;

public class Main {

    public static void main(String args[]) throws InvocationTargetException, IllegalAccessException {
        Fruit fruit = new Fruit("Mango", "Yellow");

        Field[] declaredFields = fruit.getClass().getDeclaredFields();

        for(Field field : declaredFields){
//            System.out.println(field);
        }

        Method[] declaredMethods = fruit.getClass().getDeclaredMethods();

        for(Method method : declaredMethods) {
//            System.out.println(method);

            if(Modifier.isPrivate(method.getModifiers())){
                method.setAccessible(true);
                Parameter[] parameters = method.getParameters();
//                for(Parameter parameter : parameters)
//                    System.out.println(parameter);
//                method.invoke(fruit, fruit, null);
            }
        }

        Worker1 worker1 = new Worker1();
        //        processor.process();
    }
}
