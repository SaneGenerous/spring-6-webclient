package tp.msk.spring6webclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClient client;

    @Test
    void testGetBeerByBeerStyle() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.getBeerByBeerStyle("Pale Ale")
                .subscribe(dto -> {
                    System.out.println(dto.toString());
                    atomicBoolean.set(true);
                });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetBeerById() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeerDtos()
                .flatMap(dto -> client.getBeerById(dto.getId()))
                .subscribe(byIdDto -> {
                    System.out.println(byIdDto.getBeerName());
                    atomicBoolean.set(true);
                });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetBeersDto() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeerDtos().subscribe(dtos -> {
            System.out.println(dtos.getBeerName());
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetBeersJsonNode() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeersJsonNode().subscribe(jsonNode -> {
            System.out.println(jsonNode.toPrettyString() );
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void testListBeersMap() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeersMap().subscribe(response -> {
            System.out.println(response);
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void listBeers() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeers().subscribe(response -> {
            System.out.println(response);
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }
}