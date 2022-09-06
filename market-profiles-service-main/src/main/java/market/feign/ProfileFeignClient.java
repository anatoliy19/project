package market.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "profiles-service", url = "http://localhost:8087")
public interface ProfileFeignClient {
}
