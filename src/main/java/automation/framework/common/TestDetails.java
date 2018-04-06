package automation.framework.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestDetails {

	public enum Priority {
		   LOW, MEDIUM, HIGH
		}
	
	String story1() default "";
	String story2() default "";
	String story3() default "";
	String story4() default "";
	String story5() default "";
	String story6() default "";
	
	Priority priority() default Priority.MEDIUM;

}
