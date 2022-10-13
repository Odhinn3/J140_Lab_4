
package repository;

import model.Domain;
import model.Person;
import model.User;
import java.util.List;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public interface RepositoryInterface {
    public List<User> getUsers();
    public List<Person> getPersons();
    public Person getPersonById(int identificator);
    public List<Domain> getDomainByPersonId(int personId);
}