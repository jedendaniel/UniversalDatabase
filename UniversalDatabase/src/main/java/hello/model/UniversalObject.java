package hello.model;

import org.springframework.data.annotation.Id;

import java.util.*;


public class UniversalObject {

    @Id
    public String id;
    private String name;

    private Map<String,Object> objects;

    public UniversalObject() {}

    public UniversalObject(String name){
        this.name = name;
        this.objects = new LinkedHashMap<>();
    }

    public UniversalObject(String name, Map<String,Object> objects) {
        this.name = name;
        this.objects = objects;
    }

    public void addObject(String name, Object object){
        this.objects.put(name,object);
    }

    public Object getObject(String name){
        return objects.get(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        objects.forEach(((String a, Object b) -> result.append(a + ": " + b.toString() + "\n")));
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniversalObject)) return false;
        UniversalObject that = (UniversalObject) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(objects, that.objects);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, objects);
    }
}