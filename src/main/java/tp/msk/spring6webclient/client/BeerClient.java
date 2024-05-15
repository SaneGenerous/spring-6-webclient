package tp.msk.spring6webclient.client;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tp.msk.spring6webclient.model.BeerDTO;

import java.util.Map;
import java.util.concurrent.Flow;

public interface BeerClient {
    Flux<String> listBeers();
    Flux<Map> listBeersMap();
    Flux<JsonNode> listBeersJsonNode();
    Flux<BeerDTO> listBeerDtos();
    Mono<BeerDTO> getBeerById(String id);
    Flux<BeerDTO> getBeerByBeerStyle(String beerStyle);
    Mono<BeerDTO> createBeer(BeerDTO beerDTO);
}
