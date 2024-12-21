package generic.service.impl;

import generic.dao.impl.PersonDaoImpl;
import generic.models.Person;
import generic.service.GenericService;

import java.util.List;

public class PersonServiceImpl implements GenericService<Person,Long> {
    public final PersonDaoImpl personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }


    @Override
    public String add(List<Person> people) {
      personDao.add(people);
        return "Successfully added people";
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName() {
        return personDao.sortByName();
    }

    @Override
    public List<Person> filterByGender() {
        return personDao.filterByGender();
    }

    @Override
    public List<Person> clear() {
        return personDao.clear();
    }
}
