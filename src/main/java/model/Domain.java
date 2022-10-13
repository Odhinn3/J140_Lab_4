package model;

import java.time.LocalDate;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Domain {
    private Integer id;
    private String webname;
    private String domainname;
    private String ip;
    private LocalDate datereg;
    private String countryreg;
    private Person person;

    public Domain(Integer id, String webname, String domainname, String ip, LocalDate datereg, String countryreg, Person person) {
        this.id = id;
        this.webname = webname;
        this.domainname = domainname;
        this.ip = ip;
        this.datereg = datereg;
        this.countryreg = countryreg;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDate getDatereg() {
        return datereg;
    }

    public void setDatereg(LocalDate datereg) {
        this.datereg = datereg;
    }

    public String getCountryreg() {
        return countryreg;
    }

    public void setCountryreg(String countryreg) {
        this.countryreg = countryreg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Domain{" + "id=" + id + ", webname=" + webname +
                ", domainname=" + domainname + ", ip=" + ip + ", datereg="
                + datereg + ", countryreg=" + countryreg + ", person="
                + person + '}';
    }
    
    
    
    
}
