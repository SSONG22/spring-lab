package songi.lab.spring.handlerMethodArgResolver;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import songi.lab.spring.handlerMethodArgResolver.model.ApiResult;
import songi.lab.spring.handlerMethodArgResolver.model.CustomDto;
import songi.lab.spring.handlerMethodArgResolver.model.FooBar;
import songi.lab.spring.handlerMethodArgResolver.model.Post;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class MainController {

    @GetMapping()
    public ApiResult<List<Post>> posts(@ModelAttribute CustomDto customDto) {

        return new ApiResult<>(Arrays.asList(new Post()));
    }


    @GetMapping("/test")
    public void processFooBar(FooBar fooBar, HttpServletRequest httpServletRequest){

    }
}
