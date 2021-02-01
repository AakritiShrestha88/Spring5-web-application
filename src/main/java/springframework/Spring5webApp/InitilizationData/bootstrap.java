package springframework.Spring5webApp.InitilizationData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.Spring5webApp.domain.Author;
import springframework.Spring5webApp.domain.Book;
import springframework.Spring5webApp.repositories.AuthorRepository;
import springframework.Spring5webApp.repositories.BookRepository;

@Component
public class bootstrap implements CommandLineRunner {
    //dependency injection
    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;

    public bootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//Creating the instance of author and book
        Author author = new Author("Tariq","Hook");
        Book book = new Book("Code Differently","12345");
        //Providing author book
        author.getBooks().add(book);
        //providing book=author
        book.getAuthors().add(author);


        //saving the author
        authorRepository.save(author);
        //saving the book
        bookRepository.save(book);
        Author author1= new Author("Aakriti","Shrestha");
        Book book1 = new Book("Java","23456");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        //saving the author
        authorRepository.save(author1);
        //saving the book
        bookRepository.save(book1);

        System.out.println("Started the bootstrap");
        System.out.println("Number of Books "+bookRepository.count());
        System.out.println("Number of Author "+authorRepository.count());

    }
}
