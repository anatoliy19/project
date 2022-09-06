package market.Util.Shedulers;

import market.dao.PageDtoDao;
import market.dto.PageDto;
import market.model.Advertisement;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Component
public class ShedulersAvertisments {

    PageDtoDao pageDtoDao;

    public ShedulersAvertisments(PageDtoDao pageDtoDao) {
        this.pageDtoDao = pageDtoDao;
    }

    @Scheduled(cron = "@daily")
    @Transactional
    public void setAdvertismentsPriority() {
        List<Advertisement> advPriority = pageDtoDao.getAdvertismentWithPriority();
        ZonedDateTime nowDate = ZonedDateTime.now(ZoneId.of("+3"));

        if (advPriority != null) {
            for (Advertisement advertisement : advPriority) {
                Iterator iterator = advertisement.getExpirationDate().iterator();
                while (iterator.hasNext()){
                   ZonedDateTime ExpirationDate = (ZonedDateTime) iterator.next();
                   if(ExpirationDate.compareTo(nowDate)<0){
                       advertisement.setPriority(false);
                   }
                }
            }
        }
    }
}

