package fr.intech.Java9.Object.Quest.model;

import java.util.ArrayList;
import java.util.List;

public class RequestResponse {

    private List<Annotation> annotations;

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public List<String> getDescriptions(){
        List<String> descriptions = new ArrayList<>();

        for (Annotation annotation: annotations ) {
            descriptions.add(annotation.getDescription());
        }
        return descriptions;
    }

    @Override
    public String toString() {
        return "RequestResponse{\n\t" +
                "annotations=" + annotations +
                "\n}";
    }
}
