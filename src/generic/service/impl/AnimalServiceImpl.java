package generic.service.impl;

import generic.dao.impl.AnimalDaoImpl;
import generic.db.Database;
import generic.models.Animal;
import generic.service.GenericService;

import java.util.List;

public class AnimalServiceImpl implements GenericService <Animal,Long> {

  public final  AnimalDaoImpl animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public String add(List<Animal> animals) {
       return animalDao.add(animals);
    }

    @Override
    public Animal getById(Long id) {
        return animalDao.getById(id) ;
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName() {
        return animalDao.sortByName();
    }

    @Override
    public List<Animal> filterByGender() {
        return animalDao.filterByGender();
    }

    @Override
    public List<Animal> clear() {
        return animalDao.clear();
    }
}
