package java8;

/**
 * Created by Dawid on 11.07.2017.
 */
public class Model {

    private int id;
    private String d;
    public Model(int id) {
        this.id = id;
    }

    public Model (String d){
        this.d = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", d='" + d + '\'' +
                '}';
    }
}
