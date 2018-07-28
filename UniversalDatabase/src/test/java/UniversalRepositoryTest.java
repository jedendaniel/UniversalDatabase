import hello.Application;
import hello.UniversalObject;
import hello.repository.UniversalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
@SpringBootTest(classes = Application.class)
public class UniversalRepositoryTest {

    @Autowired
    UniversalRepository universalRepository;

    UniversalObject sampleUniversalObject;

    @Before
    public void setUpData(){
        sampleUniversalObject = new UniversalObject("Laptop");
        sampleUniversalObject.addObject("price",2000);
        universalRepository.save(sampleUniversalObject);
    }

    @Test
    public void testFindWithQuery(){
        List<UniversalObject> findResults = universalRepository.findWithQuery("{'objects.price':2000}");
        Assert.assertEquals(sampleUniversalObject.getObject("price"),findResults.get(0).getObject("price"));
    }
}
