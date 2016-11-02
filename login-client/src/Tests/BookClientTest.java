import com.kainos.login.models.Book;
import com.kainos.training.jersey.client.BookClient;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ciaram on 01/11/2016.
 */
public class BookClientTest {

    @Test
    public void testBook1(){
        boolean result;
        BookClient bc = new BookClient();
        if(bc.getBooks()!=null){
            result = true;
        }else {
            result = false;
        }

        Assert.assertEquals(true, result);
    }

    @Test
    public void getBook(){
        BookClient client = new BookClient();
        Book book = client.getBook(1);
    }
}
