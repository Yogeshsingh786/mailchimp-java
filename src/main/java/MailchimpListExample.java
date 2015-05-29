import com.ecwid.mailchimp.MailChimpClient;
import com.ecwid.mailchimp.MailChimpException;
import com.ecwid.mailchimp.method.v2_0.lists.*;

import java.io.IOException;

public class MailchimpListExample {
    private static final String API_KEY = "EMAIL_TO_UNSUBSCRIBE";
    private final MailChimpClient mailChimpClient = new MailChimpClient();

    public ListMethodResult showLists() throws IOException, MailChimpException {
        ListMethod listMethod = new ListMethod();
        listMethod.apikey = API_KEY;
        ListMethodResult results = mailChimpClient.execute(listMethod);
        return results;
    }

    public static void main(String[] args) throws IOException, MailChimpException {
        ListMethodResult lists = new MailchimpListExample().showLists();
        for (ListMethodResult.Data list: lists.data) {
            System.out.println("Id:" + list.id +
                               "\tDate Created: " +       list.date_created +
                               "\tDefault From Email: " + list.default_from_email +
                               "\tMember Count:" +        list.stats.member_count);
        }
    }
}
