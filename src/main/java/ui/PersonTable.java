/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class PersonTable {
    private Integer id;
    private String jobtitle;
    private String name;
    private String phone;
    private String email;
    private Integer d;

    public PersonTable(int id, String jobtitle, String name, String phone, String email, Integer d) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.d = d;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getD() {
        return d;
    }

    public void setD(Integer domainnumber) {
        this.d = d;
    }
}
