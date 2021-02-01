package springframework.Spring5webApp.InitilizationData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.Spring5webApp.domain.Author;
import springframework.Spring5webApp.domain.Book;
import springframework.Spring5webApp.domain.Publisher;
import springframework.Spring5webApp.repositories.AuthorRepository;
import springframework.Spring5webApp.repositories.BookRepository;
import springframework.Spring5webApp.repositories.PublisherRepository;

@Component
public class bootstrap implements CommandLineRunner {
    //dependency injection
    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public bootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started the bootstrap");
//Creating the instance of author and book
        Author author = new Author("Tariq","Hook");
        Book book = new Book("Code Differently","12345");

        Publisher publisher = new Publisher();
        publisher.setName("Bikash");
        publisher.setAddressLine1("Pennsylvania");
        publisher.setState("PA");
        publisherRepository.save(publisher);

        //Providing author book
        author.getBooks().add(book);
        //providing book=author
        book.getAuthors().add(author);

        //book set pubblisher
        book.setPublisher(publisher);
        //publisher get book and add book
        publisher.getBooks().add(book);


        //saving the author
        authorRepository.save(author);
        //saving the book
        bookRepository.save(book);
        publisherRepository.save(publisher);


        Author author1= new Author("Aakriti","Shrestha");
        Book book1 = new Book("Java","23456");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        //saving the author
        authorRepository.save(author1);
        //saving the book
        bookRepository.save(book1);

        //book set pubblisher
        book1.setPublisher(publisher);
        //publisher get book and add book
        publisher.getBooks().add(book1);
        publisherRepository.save(publisher);

        System.out.println("Number of publisher "+publisherRepository.count());
        System.out.println("Number of Books "+bookRepository.count());
        System.out.println("Number of Author "+authorRepository.count());
        System.out.println("Publisher number of book"+publisher.getBooks().size());

    }
}
