package varaha.text;

import org.apache.pig.data.Tuple;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: kostperi
 * Date: 23/12/2013
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public class StanfordPosTaggerTest {


    @Test
    public void doTest() throws IOException, ParseException {


        String[] args = {
                "n=2",
        };
        PigTest test = new PigTest("src/resources/test/StanfordPosTaggerQuery1.pig", args);
        test.runScript();
        final Iterator<Tuple> tokenized = test.getAlias("tokenized");

        while (tokenized.hasNext()) {
            Tuple tpl = tokenized.next();
            System.out.println(tpl);
        }

    }
}
