package ir.maktab.model;

/**
 * Created by nader on 12/9/2017.
 */
public class Person {
    int id;
    String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
