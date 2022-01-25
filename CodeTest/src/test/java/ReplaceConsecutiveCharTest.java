import org.junit.Assert;
import org.junit.Test;
import pojo.alphabet;
import process.StringServiceImpl;

import java.util.ArrayList;

public class ReplaceConsecutiveCharTest {

    StringServiceImpl service = new StringServiceImpl();

    Integer tag = 2;

    @Test
    public void ReplaceConsecutiveCharTest0(){

        String i = this.service.Process("ccc", tag);
        String j = "b";

        Assert.assertEquals(i, j);

        i = this.service.Process("bbb", tag);
        j = "a";

        Assert.assertEquals(i, j);

        i = this.service.Process("abcccbad", tag);
        j = "d";

        Assert.assertEquals(i, j);
    }

    @Test
    public void ReplaceConsecutiveCharTest1(){

        String i = this.service.Process("aacccad", tag);
        String j = "aabad";

        Assert.assertEquals(i, j);
    }

    @Test
    public void ReplaceConsecutiveCharTest2(){

        String i = this.service.Process("aaacccdddd", tag);
        String j = "bc";

        Assert.assertEquals(i, j);
    }

    @Test
    public void ReplaceConsecutiveCharTest3(){

        String i = this.service.Process("aaacccaadddd", tag);
        String j = "baac";

        Assert.assertEquals(i, j);
    }

    @Test
    public void ReplaceConsecutiveCharTest4(){

        String i = this.service.Process("aa", tag);
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void ReplaceConsecutiveCharTest5(){

        String i = this.service.Process("aabcccbbdddbddddbddd", tag);
        String j = "cbcbc";

        Assert.assertEquals(i, j);
    }

    @Test
    public void ReplaceConsecutiveCharTest7(){

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
