package market.dao;

import java.util.List;

public interface PageDtoDao<T> {
    long getTotalEntitiesCount();
    //List<T> getEntitiesList(int currentPage, int countOnPage, String search);
    //List<T> getAdvertismentWithPriority();
}
