package generic.dao;

import java.util.List;

public interface GenericDao <T,L> {
    String add(List<T> t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName();
    List<T> filterByGender();
    List<T> clear();
}
