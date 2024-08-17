https://algo.monster/problems/oop_public_library

In this question, we ask you to design a system for a public library that allows the looking up of books. You must design the system in a way that is easily expandable.

The library has a collection of books. All books have a title, which is usually a hint to their content. When a book is put in the system, it is also assigned a unique ID to identify the book, which consists of alphanumeric characters plus -.

Right now, there are two types of books in the library:

Traditional books, where an author writes something and gets published. They can be represented as "<book name>" by <author name>. For example, "Macbeth" by W. Shakespeare (stretching a bit of the definition of a book here) or "The Lord of the Rings" by J. R. R. Tolkien. For the purpose of this question, two authors are the same if and only if the string representing them are the same, so we treat W. Shakespeare and William Shakespeare as different authors, even though they represent the same person.
Magazines, where a group of people publishes a magazine series regularly. They can be represented as "<magazine name>" Issue <issue number>. For example, "New York Times" Issue 2.
For the first part, implement these following commands:

register book [ID] [book]: Register a traditional book under the ID. If the ID is used by another book already, do nothing. Multiple copies of the same book can be registered as different IDs.
register magazine [ID] [book]: Register a magazine under the ID, following the above rules.
lookup id [ID]: Print the book who is registered as ID, followed by ID: [ID] in the following line, if such ID exists in the system. Otherwise, print "No such book exists".
lookup title [book title]: Look up a book by title (either a traditional book or a magazine). If exactly one book in the system match the title, print the book in the first line, and print ID: [ID] in the second line. If multiple books match the title, print "[number] books match the title: [title]", where number is the number of books that match the title. If no book matches the title, print "No such book exists".
lookup author [author]: Same as looking up by author, except look up a traditional book by author, and if multiple books exists, print "[number] books match the author: [author]" instead.