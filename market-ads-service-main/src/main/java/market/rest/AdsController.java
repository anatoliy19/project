package market.rest;

import market.dto.AdvertisementDto;
import market.dto.PageDto;
import market.dto.response.SuccessResponse;
import market.model.Advertisement;
import market.dto.response.Response;
import market.service.AdvertisementDtoService;
import market.service.PageDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/ads")
public class AdsController {

    private AdvertisementDtoService advertisementDtoService;
    private PageDtoService<Advertisement> pageDtoService;

    @Value("${countOnPage}")
    private int countOnPage;

    @Autowired
    public AdsController(AdvertisementDtoService advertisementDtoService, PageDtoService<Advertisement> pageDtoService) {
        this.advertisementDtoService = advertisementDtoService;
        this.pageDtoService = pageDtoService;
    }

    @GetMapping("/page")
    public Response<?> getAdvertisementPage(
            @RequestParam int currentPage,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        SuccessResponse response = Response.success(pageDtoService.getPageDto(
                        currentPage,
                        this.countOnPage,
                        search
                ));
        response.setStatus(200);
        return response;
    }

    @PostMapping
    public Response<?> postAdvertisement(@RequestBody @Valid AdvertisementDto advertisementDto
            , @RequestHeader("account_id") Long account_id
    ) {
        advertisementDtoService.add(advertisementDto, account_id);
        return Response.success().status(200).build();
    }

    @PutMapping
    public Response<?> putAdvertisement(@RequestBody @Valid AdvertisementDto advertisementDto
            , @RequestHeader("account_id") Long account_id
    ) {
        advertisementDtoService.update(advertisementDto, account_id);

        return Response.success().status(200).build();
    }

    @DeleteMapping("/{id}")
    public Response<?> deleteAdvertisement(@PathVariable long id) {
        advertisementDtoService.delete(id);

        return Response.success().status(200).build();
    }

}
