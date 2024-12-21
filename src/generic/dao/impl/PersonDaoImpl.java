package generic.dao.impl;

import generic.dao.GenericDao;
import generic.db.Database;
import generic.models.Person;
import generic.service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class PersonDaoImpl  implements GenericDao<Person,Long> {

    @Override
    public String add(List<Person> persons) {
         Database.personList.addAll(persons);
        return "Successfully added Person !";
        }

        @Override
    public Person getById(Long id) {
            for (Person person : Database.personList) {
                if (person.getId().equals(id)){
                    return person;
                }
            }

           throw new NoSuchElementException("Person with "+  id + "not found");
    }

    @Override
    public List<Person> getAll() {
        return Database.personList;
    }

    @Override
    public List<Person> sortByName() {
        List<Person> personList = getAll();
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return personList;
    }

    @Override
    public List<Person> filterByGender() {
     List<Person> personList = getAll();
     personList.sort(new Comparator<Person>() {
         @Override
         public int compare(Person o1, Person o2) {
             return o1.getGender().compareTo(o2.getGender());
         }
     });

     return personList;
    }

    @Override
    public List<Person> clear() {
        List<Person> personList = getAll();
        personList.clear();
        return personList ;
    }
}
