public class main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertAfter(20, 25);
        list.insertBefore(10, 5);

        list.display();  // 5 -> 10 -> 20 -> 25 -> 30 -> END

        list.delete(5);   // delete head
        list.delete(25);  // delete middle
        list.delete(30);  // delete tail

        list.display();  // 10 -> 20 -> END
    }
}
