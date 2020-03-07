import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyCompare {
}

/*
自定义类型要进行比较
    1. 需要实现Comparable接口中的compareTo方法--->自然排序的实现方式
    2. 实现比较器Comparator接口中的compare方法--->非自然排序的实现方式
 */
class Person implements Comparable<Person>{
//class Person{

    public String name;
    public String gender;
    public int age;
    public String ID;

    Person(String name, String gender, int age, String id){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ID = id;
    }

    @Override
    public int compareTo(Person o) {
        int ret = age - o.age;
        if(ret < 0)
            return -1;
        else if(ret > 0)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return name + "--" + gender + "--" + age + "--" + ID;
    }
}

class PersonAgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        int ret = o1.age - o2.age;
        if(ret < 0)
            return -1;
        else if(ret > 0)
            return 1;
        else
            return 0;
    }
}

class PersonIDComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return -o1.compareTo(o2);  // o1 > o2 : > 0,  o1 < o2: < 0  o1 == o2 : 0
    }
}

class test1{
    public static void main(String[] args) {
        int[] arr = {1,3,8,4};
        Person[] personArr = {new Person("王继文", "男", 19, "123456"),
                new Person("赵军杰", "男", 18, "19"),
                new Person("赵俊杰", "男", 29, "103456"),} ;
        Arrays.sort(arr);
        //Person 已经实现了Comparable中的compareTo方法
        Arrays.sort(personArr);
        System.out.println("年龄比较：");
        System.out.println(Arrays.toString(personArr));

        // 如果己经有了Person类型的比较器
        Arrays.sort(personArr, new PersonIDComparator());
        System.out.println("ID比较：");
        System.out.println(Arrays.toString(personArr));

        String[]  strArr = {"1111", "456"};
        System.out.println(strArr[0].compareTo(strArr[1]));
        Arrays.sort(strArr);

    }

}

class IntegerComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

class IntegerComparator2 implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

class Test3{}

class Test3Comparator implements Comparator<Test3>{
    @Override
    public int compare(Test3 o1, Test3 o2) {
        return 0;
    }
}

class test2{
    public static void main(String[] args) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>(new IntegerComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new IntegerComparator2());

        pq.offer(10);
        pq.offer(100);
        pq.offer(1);
        pq.offer(15);
        pq.offer(0);
        pq.offer(-1);
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
        System.out.println();

        PriorityQueue<Test3> pq2 = new PriorityQueue<Test3>(new Test3Comparator());
        pq2.offer(new Test3());
        pq2.offer(new Test3());
        pq2.offer(new Test3());

    }

}
