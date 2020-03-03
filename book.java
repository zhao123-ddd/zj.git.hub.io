import java.util.Objects;

public class book  implements Comparable<book>{
    public String IBNS;
    public String name;
    public String author;
    public int price;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        book book = (book) o;
        return Objects.equals(IBNS, book.IBNS);
        /* if(o ==null){
        return false;
         }
        if(!(o instanceof book)){
            return false;
        }
         book b=(book) o;
        return this.IBNS.equals(b.IBNS);*/
    }



    public static void main(String[] args) {
        book book1=new book();
        book book2=new book();
        book1.author="xiao";
        book1.name="dsad";
        book1.IBNS="1351351";
        book1.price=18;
        book2.author="xiao";
        book2.name="dsad";
        book2.IBNS="1351351";
        book2.price=19;
        System.out.println(book1.equals(book2));
        System.out.println(book1.compareTo(book2));
    }


    @Override
    public int compareTo(book o) {
  return this.price-o.price;
    }
}
