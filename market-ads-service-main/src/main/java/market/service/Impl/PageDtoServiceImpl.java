package market.service.Impl;

import market.Util.Sorting.SortingDateAdvertisment;
import market.Util.Sorting.SortingPriorityAdvertisment;
import market.dao.PageDtoDao;
import market.dto.PageDto;
import market.model.Advertisement;
import market.service.PageDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageDtoServiceImpl<T> implements PageDtoService<T> {

    private PageDtoDao<T> pageDtoDao;

    @Autowired
    public PageDtoServiceImpl(PageDtoDao<T> pageDtoDao) {
        this.pageDtoDao = pageDtoDao;
    }

    @Override
    public PageDto<T> getPageDto(int currentPage, int countOnPage, String search) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setTotalEntitiesCount(pageDtoDao.getTotalEntitiesCount());
        pageDto.setCurrentPage(currentPage);
        pageDto.setCountOnPage(countOnPage);
        pageDto.setPageCount((int)(pageDto.getTotalEntitiesCount() / countOnPage) + 1);

        List<Advertisement> forSorted = (List<Advertisement>) pageDtoDao
                .getEntitiesList(currentPage, countOnPage, search);

        List<Advertisement> sortedAvertisment = forSorted
                .stream()
                .sorted(new SortingPriorityAdvertisment().thenComparing(new SortingDateAdvertisment()))
                .collect(Collectors.toList());
        pageDto.setEntities((List<T>) sortedAvertisment);

        return pageDto;
    }

}