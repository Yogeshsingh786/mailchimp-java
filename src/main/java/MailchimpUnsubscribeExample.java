import com.ecwid.mailchimp.MailChimpClient;
import com.ecwid.mailchimp.MailChimpException;
import com.ecwid.mailchimp.method.v2_0.lists.*;

import java.io.IOException;

public class MailchimpUnsubscribeExample {

    private static final String API_KEY = "MAILCHIMP_KEY";
    private static final String LIST_ID = "LIST_ID";
    private static final String EMAIL= "EMAIL_TO_UNSUBSCRIBE";
    private final MailChimpClient mailChimpClient = new MailChimpClient();

    public Boolean unsubscribe(String listId, String email) throws IOException, MailChimpException {
        UnsubscribeMethod unsubscribeMethod = new UnsubscribeMethod();
        unsubscribeMethod.apikey = API_KEY;
        unsubscribeMethod.id = listId;
        unsubscribeMethod.email = new Email();
        unsubscribeMethod.email.email = email;
        DummyResult result = mailChimpClient.execute(unsubscribeMethod);
        return result.complete;
    }

    public static void main(String[] args) throws IOException, MailChimpException {
        Boolean unsubscribe = new MailchimpUnsubscribeExample().unsubscribe(LIST_ID, EMAIL);
        System.out.println("Unsubscribe successful: " + unsubscribe);
    }
}
