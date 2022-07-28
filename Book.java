package mongodb;

public class Book {
    Author author;
    String title;
    int year;
    String publisher;
    String genre;
    double rating;
    double price;

    public Book() {
    }

    public Book(Author author, String title, int year, String publisher, String genre, double rating, double price) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }

    
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}' + '\n';
    }
}