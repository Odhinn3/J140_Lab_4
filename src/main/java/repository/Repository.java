package repository;
import model.Domain;
import model.Person;
import model.User;
import main.ApplicationProperties;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */

public class Repository implements RepositoryInterface{
    
    private final String url = ApplicationProperties.get().getProperty("db.url");
    private final String dbUser = ApplicationProperties.get().getProperty("db.user");
    private final String dbPassword = ApplicationProperties.get().getProperty("db.password");
    
    @Override
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        try(Statement stm = getConnection().createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM users")){
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                User user = new User(id, name, password);
                list.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        try(Statement stm = getConnection().createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person")){
            while(rs.next()){
                int id = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String name = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(id, jobtitle, name, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
        @Override
    public Person getPersonById(int identificator) {
        List<Person> list = new ArrayList<>();
        try(Statement stm = getConnection().createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person WHERE id=" + identificator)){
            while(rs.next()){
                int id = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String name = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(4);
                Person person = new Person(id, jobtitle, name, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list.isEmpty() ? null : list.get(0);
    }
    
    @Override
    public List<Domain> getDomainByPersonId(int personId) {
        Person person = getPersonById(personId);
        List<Domain> list = new ArrayList<>();
        if(person!=null){
            try(Statement stm = getConnection().createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM domains WHERE personid=" + person.getId())){
                while(rs.next()){
                    Domain domain = new Domain(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getDate(5).toLocalDate(),
                            rs.getString(6),
                            getPersonById(personId));
                    list.add(domain);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
}