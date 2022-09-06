package market.service;

import market.dto.PageDto;

public interface PageDtoService <T>{
    PageDto<T> getPageDto(int currentPage, int countOnPage, String search);
}
