package model;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Person {
    private int id;
    private String jobtitle;
    private String name;
    private String phone;
    private String email;

    public Person(int id, String jobtitle, String name, String phone, String email) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", jobtitle=" + jobtitle + ", name=" + name + ", phone=" + phone + ", email=" + email + '}';
    }   
}