package org.arunav.java.annotation.processor;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes("org.arunav.java.annotation.Work")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
@AutoService(Processor.class)
public class WorkProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment){
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        System.out.println("process");

        for(TypeElement annotation : annotations) {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotation);

            for(Element element : elements) {
                if(element.getKind() != ElementKind.CLASS) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Can annotate only classes");
                    break;
                }
                List<? extends Element> enclosedElements = element.getEnclosedElements();
                int count = 0;
                for(Element encElement : enclosedElements) {
                    if(encElement.getKind() == ElementKind.METHOD && encElement.getSimpleName().toString().equals("process")) {
                        ExecutableType type = (ExecutableType) encElement.asType();
                        List<? extends TypeMirror> parameterTypes = type.getParameterTypes();

                        switch (parameterTypes.size()) {
                            case 0:
                                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "No parameters passed in process() method of " + element.getSimpleName());
                                break;
                            case 1:
                                if(!parameterTypes.getFirst().toString().equals("java.lang.String")) {
                                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "String should be passed as the only parameter in process() method of " + element.getSimpleName());
                                }
                                break;
                            default:
                                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Too many parameters in process() method of " + element.getSimpleName());
                                break;
                        }
                        count++;
                    }
                }
                if(count == 0){
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Implement process() method in " + element.getSimpleName());
                    return false;
                }
            }
        }

        return true;
    }
}
