package ques1;

import java.lang.reflect.Method;

public class DemoAnnotationReflection {
	public static void main(String[] args) {

		try {
			Class<?> class1 = Class.forName("ques1.Annotated");

			Author author = class1.getAnnotation(Author.class);
			System.out.println("Annotated @Author: " + author.name());
			Version version = class1.getAnnotation(Version.class);
			System.out.println("Version : " + version.number());

			Method[] m = class1.getDeclaredMethods();
			Author method = m[0].getAnnotation(Author.class);
			System.out.println("AnnotatedMethod1 @Author:" + method.name());
			Version method1 = m[0].getAnnotation(Version.class);
			System.out.println("Version :" + method1.number());

			Author method2 = m[1].getAnnotation(Author.class);
			System.out.println("AnnotatedMethod2 @Author:" + method2.name());
			Version method3 = m[1].getAnnotation(Version.class);
			System.out.println("Version :" + method3.number());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
