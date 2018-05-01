import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.lundsten.model.rest.CreateIndividualRequest;

@Controller
public class ApiController {

    @GetMapping("/test")
    @ResponseBody
    public String test (){
        String test = "test";
        return test;
    }
    @GetMapping("/individual")
    @ResponseBody
    public CreateIndividualRequest IndividualRequest() {
        return new CreateIndividualRequest();
    }

}
