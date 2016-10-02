package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.ibm.watson.developer_cloud.language_translation.v2.model.*;
import com.ibm.watson.developer_cloud.language_translation.v2.*;

import com.ibm.watson.developer_cloud.conversation.v1.*;
import com.ibm.watson.developer_cloud.conversation.v1.model.*;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.*;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getTranslatedResult();
        //response.setContentType("text/html");
        //response.getWriter().print("result is " + result.toString());
        //System.out.println("result is " + result);
        response.setContentType("application/json");
        response.getWriter().print("This is test of modification 2");
    }
    
    private static LanguageTranslation service = new LanguageTranslation();
    private static TranslationResult result;
    
    public static void getTranslatedResult() {
    	//System.getenv("VCAP_SERVICES");
    	//service.setUsernameAndPassword("d02a80d2-fb2a-4941-9d74-7ed0e72541c4", "i6YdoXRKCWEz");
    	service.setEndPoint("https://gateway.watsonplatform.net/language-translator/api");
    	service.setUsernameAndPassword("d02a80d2-fb2a-4941-9d74-7ed0e72541c4", "i6YdoXRKCWEz");
    	result = service.translate("This is test of translation in English", Language.ENGLISH, Language.SPANISH).execute();
    }
    
    /*private static ConversationService service = new ConversationService("2016-09-30");
    
    public static void main(String[] args) {
    	service
    }*/
}
