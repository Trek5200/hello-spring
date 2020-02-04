package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created as part of Chapter 10 reading
 * Updated as part of 11.5 Conditionals in a Template
 */

@Controller
//@ResponseBody // tells simple string response; Moved to here since it was used in every method
@RequestMapping ("hello")  // Added here since @GetMapping and @RequestMapping used for methods
public class HelloController {

    //Very important to get routing correct:
    //configure controllers and their handler methods
    //with the appropriate routes and the
    //appropriate HTTP methods

    // Handles request at path /hello
    // This section commented out to prevent conflict with method using @RequestParam below
//    @GetMapping("hello")  //designates a controller action with a URL path ex] http://localhost:8080/hello
//    @ResponseBody // tells simple string response
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // Handles request at path /goodbye
    // after adding @RequestMapping ("hello") before class, now lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody // tells simple string response
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Create a handler that creates requests of the form /hello?name=LaunchCode
    // replaced @GetMapping("hello") to make helloWithQueryParam both get and post
    // after adding @RequestMapping ("hello") before class, now lives at /hello/hello
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
////    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})  //removed value="hello" since @RequestMapping ("hello") added before class
////    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
////    public String helloWithQueryParam(@RequestParam String name, @RequestParam String friend){
////        return "Hello, " + name + " and " + friend + "!";
//    }

//    //Added method hello in for 11.5.2 Thymeleaf Part 2: Dynamic templates
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
//    @ResponseBody
//    public static String hello(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
//    //Added method helloAgain in for 11.5.2 Thymeleaf Part 2: Dynamic templates
//    @GetMapping("hello/{name}")  // removed hello/ since @RequestMapping ("hello") added before class
//    @ResponseBody
//    public String helloAgain(@PathVariable String name){
//        return "Hello, " + name +"!";


    // handler that handles the request in the form /hello/{name}
    // Note: LaunchCode is now part of the path and not part of the query string
//    @GetMapping("hello/{name}")
    @GetMapping("{name}")  // removed hello/ since @RequestMapping ("hello") added before class
    //@ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
//        public String helloWithPathParam(@PathVariable String name, @PathVariable String friend){
//            return "Hello, " + name + " and " + friend + "!";
    }

//    //Commented out to preserve this code
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
//    @ResponseBody
//    public static String createMessage(@RequestParam String name, @RequestParam String language){
//        return "<html>" +
//                "<body style=\"background-color:DodgerBlue;" +
//                "color:orange;" +
//                "font-size:500%;" +
//                "text-align:center\">" +
//                "<b>" + language + " " + name + "<b>" +
//                "</body>" +
//                "</html>";
//    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
//    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language, Model model){
        String theGreeting = language + " " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    // after adding @RequestMapping ("hello") before class, now lives at /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return "form";
//                "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" +   //submit a request to /hello
//                "<input type='text' name='name'>" +
////                "<input type='text' name='language'>" +
//                "<select name='language'>" +
//                "   <option value='Hello'>English</option>" +
//                "   <option value='Bonjour'>French</option>" +
//                "   <option value='Hola'>Spanish</option>" +
//                "   <option value='Hallo'>German</option>" +
//                "   <option value='Hei'>Finnish</option>" +
//                "</select>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
    }
        @GetMapping("hello-names")
        public String helloNames(Model model){
            List<String> names = new ArrayList<>();
            names.add("LaunchCode");
            names.add("Javascript");
            names.add("Java");
            model.addAttribute("names", names);
            return "hello-list";
        }
}
