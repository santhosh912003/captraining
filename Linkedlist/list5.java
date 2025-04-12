public class list5 {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addAtEnd("The Alchemist", "Paulo Coelho", "Fiction", 101, true);
        lib.addAtBeginning("1984", "George Orwell", "Dystopian", 102, true);
        lib.addAtPosition("To Kill a Mockingbird", "Harper Lee", "Classic", 103, false, 1);
        lib.addAtEnd("Brave New World", "Aldous Huxley", "Sci-Fi", 104, true);

        System.out.println("All Books (Forward):");
        lib.displayForward();

        System.out.println("\nAll Books (Reverse):");
        lib.displayReverse();

        System.out.println("\nSearch by Title:");
        lib.searchByTitle("1984");

        System.out.println("\nSearch by Author:");
        lib.searchByAuthor("George Orwell");

        System.out.println("\nUpdate Availability (Book ID 103 to Available):");
        lib.updateAvailability(103, true);
        lib.displayForward();

        System.out.println("\nRemove Book ID 104:");
        lib.removeByBookId(104);
        lib.displayForward();

        System.out.println("\nTotal Books: " + lib.countBooks());
    }
}


class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;
    Book tail;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int index = 0;
        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }
    }

    public void removeByBookId(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.title + " - " + temp.author + " - " + temp.genre + " - " + temp.bookId + " - " + (temp.isAvailable ? "Available" : "Not Available"));
            }
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.title + " - " + temp.author + " - " + temp.genre + " - " + temp.bookId + " - " + (temp.isAvailable ? "Available" : "Not Available"));
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.author + " - " + temp.genre + " - " + temp.bookId + " - " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.author + " - " + temp.genre + " - " + temp.bookId + " - " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    public int countBooks() {
        Book temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}