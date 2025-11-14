package baseUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformerUtility implements IAnnotationTransformer {
	 @Override
	    public void transform(ITestAnnotation annotation, Class testClass,
	                          Constructor testConstructor, Method testMethod) {

	        annotation.setRetryAnalyzer(RetryanalyzerUtility.class);
	    }
}
