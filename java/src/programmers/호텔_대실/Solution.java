// prob: https://school.programmers.co.kr/learn/courses/30/lessons/155651

package programmers.호텔_대실;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int solution(String[][] bookTimes) {
        List<Book> books = createBooks(bookTimes);
        books.sort((v1, v2) -> {
            if (!v1.start.equals(v2.start)) {
                return v1.start.compareTo(v2.start);
            }
            return v1.end.compareTo(v2.end);
        });
        return createBookOfMaxCount(books);
    }

    private List<Book> createBooks(String[][] bookTimes) {
        List<Book> books = new ArrayList<>();
        for (String[] bookTime : bookTimes) {
            LocalTime startBookTime = LocalTime.parse(bookTime[0]);
            LocalTime endBookTime = LocalTime.parse(bookTime[1]).plusMinutes(10);
            if (LocalTime.parse(bookTime[1]).isAfter(endBookTime)) {
                endBookTime = LocalTime.MAX;
            }
            books.add(new Book(startBookTime, endBookTime));
        }
        return books;
    }

    private int createBookOfMaxCount(List<Book> books) {
        int countBooks = 1;
        Queue<Book> bookQueue = new PriorityQueue<>(Comparator.comparing(v -> v.end));
        for (Book nowBook : books) {
            if (bookQueue.isEmpty()) {
                bookQueue.add(nowBook);
                continue;
            }
            Book bookOfMinEndTime = bookQueue.peek();
            if (bookOfMinEndTime.end.isBefore(nowBook.start)
                || bookOfMinEndTime.end.equals(nowBook.start)) {
                bookQueue.remove();
            }
            bookQueue.add(nowBook);
            countBooks = Math.max(countBooks, bookQueue.size());
        }
        return countBooks;
    }

    private static class Book {

        private final LocalTime start;
        private final LocalTime end;

        public Book(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }
    }

}
