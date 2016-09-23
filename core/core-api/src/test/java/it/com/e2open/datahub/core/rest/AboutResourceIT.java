package it.com.e2open.datahub.core.rest;

import com.e2open.datahub.core.rest.AboutResource;
import com.e2open.datahub.core.rest.DXResourceConfig;
import it.com.e2open.datahub.core.TestDXApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TestDXApplication.class, AboutResource.class, DXResourceConfig.class})
public class AboutResourceIT {

    @Inject
    private TestRestTemplate restTemplate;

    @Test
    public void about() throws Exception {

        ResponseEntity<Map> forEntity = restTemplate.getForEntity("/service/about", Map.class);
        Assert.assertEquals(HttpStatus.OK, forEntity.getStatusCode());
        Assert.assertEquals(Collections.emptyMap(), forEntity.getBody());
    }

}