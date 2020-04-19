package com.Arrays.SortingFs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionReverse {
    public static class User implements Comparable<User> {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(User o) {
            return name.compareTo(o.getName());
        }
    }
//    ...Natural Order...
//    Mohan Rahim Sohan
//...Reverse Order...
//    Sohan Rahim Mohan
    public static void main(String[] args) {
        User u1 = new User("Mohan");
        User u2 = new User("Sohan");
        User u3 = new User("Rahim");
        User[] users = {u1, u2, u3};
        System.out.println("...Natural Order...");
        Arrays.sort(users);
        for(User u: users){
            System.out.print(u.getName()+" ");
        }
//        Collections.reverseOrder with Comparable
//        It returns a Comparator that will reverse the natural ordering imposed by Comparable.
        System.out.println("\n...Reverse Order...");
        Arrays.sort(users, Collections.reverseOrder());
        for(User u: users){
            System.out.print(u.getName()+" ");
        }

        // ================== same thing with new Comparator class =========================//
        User u11 = new User("Mohan");
        User u22 = new User("Sohan");
        User u33 = new User("Rahim");
        User[] users1 = {u11, u22, u33};
        System.out.println("...Order with Comparator...");
        Arrays.sort(users, new UserComparator());
        for(User u: users1){
            System.out.print(u.getName()+" ");
        }
//        Collections.reverseOrder with Comparator
//        It returns a Comparator that will reverse the natural ordering imposed by Comparator.
        System.out.println("\n...Reverse Order with Comparator...");
        Arrays.sort(users1, Collections.reverseOrder(new UserComparator()));
        for(User u: users1){
            System.out.print(u.getName()+" ");
        }
        // ================ simple Collections.reverse(List) ==============================//

        User u1r = new User("Mohan");
        User u2r = new User("Sohan");
        User u3r = new User("Rahim");
        List<User> list = Arrays.asList(u1r, u2r, u3r);
        System.out.println("...Before Reverse...");
        for(User u: list){
            System.out.print(u.getName()+" ");
        }
//     ...Before Reverse...
//        Mohan Sohan Rahim
//     ...After Reverse...
//        Rahim Sohan Mohan
        System.out.println("\n...After Reverse...");
        Collections.reverse(list);
        for(User u: list){
            System.out.print(u.getName()+" ");
        }
    }
//    ...Order with Comparator...
//    Mohan Rahim Sohan
//...Reverse Order with Comparator...
//    Sohan Rahim Mohan
    public static class UserComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
