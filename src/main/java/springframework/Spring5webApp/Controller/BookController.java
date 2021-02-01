package springframework.Spring5webApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.Spring5webApp.repositories.BookRepository;

//2.
//This is spring stereotype which tells the spring framework our intent is to make this
// into Spring MVC controller.
@Controller

//1.create a class
public class BookController {
    //5.we wanna enhance that model with list of book
    //6.We are asking spring to inject the instance of book repository
    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //3.to create method and annotation
    @RequestMapping("/books")
    //the annotation is used to map web requests to Spring Controller methods.
    //4.create model
    public String getBooks(Model model){
        /**7.when run time when spring gets request /books. its going to execute the getbooks method
        its gonna provide that method model object and for that model we are going to add books and execute book repository
        whic is going to give list of books
         **/
        model.addAttribute("books",bookRepository.findAll());
        return "books/list";
    }
}
