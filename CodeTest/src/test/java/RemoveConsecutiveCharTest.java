import org.junit.Assert;
import org.junit.Test;
import process.PublicFunctions;
import process.StringServiceImpl;

public class RemoveConsecutiveCharTest {
    StringServiceImpl service = new StringServiceImpl();

    Integer tag = 1;

    @Test
    public void RemoveConsecutiveCharTest1(){

        String i = this.service.Process("aacccad", tag);
        String j = "d";

        Assert.assertEquals(i, j);
    }

    @Test
    public void RemoveConsecutiveCharTest2(){

        String i = this.service.Process("aacccadddd", tag);
        String j = "";

        Assert.assertEquals(i, j);
    }

    @Test
    public void RemoveConsecutiveCharTest3(){

        String i = this.service.Process("aaacccadddd", tag);
        String j = "a";

        Assert.assertEquals(i, j);
    }

    @Test
    public void RemoveConsecutiveCharTest4(){

        String i = this.service.Process("aa", tag);
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void RemoveConsecutiveCharTest5(){

        String i = this.service.Process("aabcccbbdddbddddbddd", tag);
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void RemoveConsecutiveCharTest7(){

        String i = this.service.Process("a3", tag);
        String j = "";

        Assert.assertEquals(i, j);

        i = this.service.Process("aAa", tag);
        j = "";

        Assert.assertEquals(i, j);

        i = this.service.Process("a ", tag);
        j = "";

        Assert.assertEquals(i, j);

        i = this.service.Process("a$", tag);
        j = "";

        Assert.assertEquals(i, j);
    }



}
