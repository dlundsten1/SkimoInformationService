import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.lundsten.model.rest.CreateIndividualRequest;
import se.lundsten.model.rest.IndividualRestPath;

@Controller
public class ApiController {

    @GetMapping(IndividualRestPath.INDIVIDUAL_PATH)
    @ResponseBody
    public CreateIndividualRequest individul() {
        CreateIndividualRequest test = CreateIndividualRequest.newBuilder().build();
        return test;
    }
}
