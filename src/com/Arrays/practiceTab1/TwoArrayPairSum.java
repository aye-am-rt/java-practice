package com.Arrays.practiceTab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoArrayPairSum {
    public static void main(String[] args) throws IOException {
        System.out.print("give sum of pair to find in both array = ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int sum=Integer.parseInt(br.readLine().strip());
        System.out.print("give space separated integers for array 1 = ");
        int[] arr1= Arrays.stream(br.readLine().strip().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.print("give space separated integers for array 2 = ");
        int[] arr2= Arrays.stream(br.readLine().strip().split("\\s"))
                .mapToInt(x->Integer.parseInt(x)).toArray();
//        System.out.println("given array 1 = ");
//        Arrays.stream(arr1).forEach(x-> System.out.print(x+" "));
//        System.out.println("\ngiven array 2 = ");
//        Arrays.stream(arr2).forEach(x-> System.out.print(x+" "));
////        System.out.println("********");
////        System.out.println(arr1[3]+arr2[3]);
        System.out.println(findPairSum(arr1,arr2,sum));
    }

    private static String findPairSum(int[] arr1, int[] arr2, int sm) {
//        Set<Integer> sar1=new HashSet<>(Arrays.<Integer>asList(1,2,1,1));
//        Integer[] boxedArray = IntStream.of(arr1).boxed().toArray(Integer[]::new);
//        LinkedHashSet<Integer> sar1 = IntStream.of(arr1).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
//        System.out.println(sar1);
//        int[] absDiff=Arrays.stream(arr1).map(i -> Math.abs(sm-i)).toArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int l1=arr1.length;
        int l2=0;
        int ans=20000;
        while (l1 > 0 && l2 < arr2.length)
        {
           if(Math.abs(arr1[l1-1]+arr2[l2]-sm)<ans)
           {
               ans=Math.abs(arr1[l1-1]+arr2[l2]-sm);
               System.out.println(" answer indices in sorted arrays == ");
               System.out.println("ans= "+ans+" l1= "+l1+" l2= "+l2);
           }
           else if(arr1[l1-1]+arr2[l2]>=sm)
           {
               --l1;
           }
           else if(arr1[l1-1]+arr2[l2]<=sm)
           {
               ++l2;
           }
            //System.out.println("l1= "+l1+" l2= "+l2);
        }
        return null;
    }
}
/**  sar1.forEach(i -> Math.abs(sm-i));
 for (int i : sar1) {
 sar1.add(Math.abs(sm-i));
 //sar1.remove(i);
 }
 Iterator<Integer> i = sar1.iterator();
 while (i.hasNext())
 {
 sar1.add(Math.abs(sm-Integer.valueOf(String.valueOf(i))));
 //sar1.remove(i);
 }
 **/

/****
    The question asks two separate questions: converting int[] to Integer[] and creating a HashSet<Integer> from an int[]. Both are easy to do with Java 8 streams:

        int[] array = ...
        Integer[] boxedArray = IntStream.of(array).boxed().toArray(Integer[]::new);
        Set<Integer> set = IntStream.of(array).boxed().collect(Collectors.toSet());
//or if you need a HashSet specifically
        HashSet<Integer> hashset = IntStream.of(array).boxed()
        .collect(Collectors.toCollection(HashSet::new));

 //////////////////////////////////////////////////////////////////////////////////////////////////////////
 Set in Java is a part of java.util package and extends java.util.Collection interface.
 The Java Set does not provide control over the position of insertion or deletion of elements.
 Basically, Set is implemented by HashSet, LinkedHashSet or TreeSet (sorted representation).

//////////////////////////////////////////////////////////////////////////////////////////////////////
 Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
 Set<Integer> targetSet = new HashSet<Integer>(Arrays.asList(sourceArray));

 /////////////////////////////////////////////////////////////////////////////////////////////////////////

 Set<T> set = new HashSet<>();
 Collections.addAll(set, Arrays.toString(array));

 /////////////////////////////////////////////////////////////////////////////////////////////////////////

 Set<T> set = new HashSet<>(Arrays.asList(array));

 //////////////////////////////////////////////////////////////////////////////////////////////////////

 Some further explanation. The asList method has this signature

public static <T> List<T> asList(T... a)
        So if you do this:

        List<Integer> list = Arrays.asList(1, 2, 3, 4)
        or this:

        List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4 })
        In these cases, I believe java is able to infer that you want a List back, so it fills in the type parameter, which means it expects Integer parameters to the method call. Since it's able to autobox the values from int to Integer, it's fine.

        However, this will not work

        List<Integer> list = Arrays.asList(new int[] { 1, 2, 3, 4} )
        because primitive to wrapper coercion (ie. int[] to Integer[]) is not built into the language (not sure why they didn't do this, but they didn't).

        As a result, each primitive type would have to be handled as it's own overloaded method, which is what the commons package does. ie.

public static List<Integer> asList(int i...);
***********/

