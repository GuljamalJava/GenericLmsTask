package generic.dao.impl;

import generic.dao.GenericDao;
import generic.db.Database;
import generic.models.Animal;
import generic.models.Person;

import java.util.Comparator;
import java.util.List;

public class AnimalDaoImpl implements GenericDao <Animal,Long>{

    @Override
    public String add(List<Animal> animals) {
        Database.animalList.addAll(animals);
        return "Successfully added animals";
    }



    @Override
    public Animal getById(Long id) {
        for (Animal animal : Database.animalList) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return Database.animalList;
    }

    @Override
    public List<Animal> sortByName() {
       List<Animal> animals = getAll();
      animals.sort(new Comparator<Animal>() {
          @Override
          public int compare(Animal o1, Animal o2) {
              return o1.getName().compareTo(o2.getName());
          }
      });
      return animals;
    }

    @Override
    public List<Animal> filterByGender() {
       List <Animal> animals = getAll();
       animals.sort(new Comparator<Animal>() {
           @Override
           public int compare(Animal o1, Animal o2) {
               return o1.getGender().compareTo(o2.getGender());
           }
       });
       return animals;
    }

    @Override
    public List<Animal> clear() {
      List<Animal> animals = getAll();
      animals.clear();
      return animals;
    }
}
