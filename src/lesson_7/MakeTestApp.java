package lesson_7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class MakeTestApp {


    public static void main(String[] args) {
        start(ClassForTest.class);
    }


    public static void start(Class<?> name){
        Method[] methods = name.getDeclaredMethods();
        int min_p = 1;
        int max_p = 10;
        Map<Integer, Method> methodMap = new TreeMap<>();
        for (Method meth : methods) {
            if(meth.getAnnotation(BeforeSuite.class) != null){
                methodMap.put(min_p - 1, meth);
            }
            if(meth.getAnnotation(AfterSuite.class) != null){
                methodMap.put(max_p + 1, meth);
            }
            if (meth.getAnnotation(Test.class) != null){
                Test test = meth.getAnnotation(Test.class);
                methodMap.put(test.priority(), meth);
            }
        }
        try{
            Object classForTest = name.newInstance();
            for(Integer key : methodMap.keySet()){
                methodMap.get(key).invoke(classForTest);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
