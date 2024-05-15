package tp.msk.spring6webclient.client;

import reactor.core.publisher.Flux;

import java.util.Map;

public interface BeerClient {
    Flux<String> listBeers();
    Flux<Map> listBeersMap();
}
