class inheri4 {
    public static void main(String[] args) {
        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "An American novelist famous for his depiction of the Jazz Age.");
        author.displayInfo();
    }
}

class Book {
    String title;
    int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        System.out.println("Title: " + title + ", Publication Year: " + publicationYear);
        System.out.println("Author: " + name + ", Bio: " + bio);
    }
}