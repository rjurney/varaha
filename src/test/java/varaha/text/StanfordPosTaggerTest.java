package varaha.text;

import org.apache.pig.data.Tuple;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: kostperi
 * Date: 23/12/2013
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public class StanfordPosTaggerTest {


    String[] checks = {
         "{(Call,VB),(me,PRP),(Ishmael,NNP),(.,.)}",
         "{(Some,DT),(years,NNS),(ago,RB),(--,:),(never,RB),(mind,VB),(how,WRB),(long,JJ),(precisely,RB),(--,:),(having,VBG),(little,JJ),(or,CC),(no,DT),(money,NN),(in,IN),(my,PRP$),(purse,NN),(,,,),(and,CC),(nothing,NN),(particular,JJ),(to,TO),(interest,NN),(me,PRP),(on,IN),(shore,NN),(,,,),(I,PRP),(thought,VBD),(I,PRP),(would,MD),(sail,VB),(about,IN),(a,DT),(little,JJ),(and,CC),(see,VB),(the,DT),(watery,JJ),(part,NN),(of,IN),(the,DT),(world,NN)}"
    };

    @Test
    public void doTest() throws IOException, ParseException {


        String[] args = {

        };
        PigTest test = new PigTest("src/resources/test/StanfordPosTaggerQuery1.pig", args);
        test.runScript();
        final Iterator<Tuple> posTags = test.getAlias("posAnnotated");

        int cnt = 0;
        while (posTags.hasNext()) {
            Tuple tpl = posTags.next();

            assertEquals( checks[cnt], tpl.get(0).toString() );
            cnt++;
        }

    }
}
