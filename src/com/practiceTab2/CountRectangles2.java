package com.practiceTab2;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CountRectangles2 {

    private static class Int
    {
        private int i=0;

        public void add()
        {
            i++;
        }

        public int getInt()
        {
            return i;
        }
    }

    private static class Point implements Comparable<Point>
    {
        int x;
        int y;

        public int compareTo(Point o)
        {
            if(x>o.x)
            {
                return 1;
            }
            else if(x==o.x)
            {
                return y-o.y;
            }
            else
            {
                return -1;
            }
        }

        public String toString()
        {
            return "["+x+","+y+"]";
        }
    }


    public static void main(String[] args) throws IOException
    {
        byte[] arr=new byte[8192];
        byte b;
        int cread=0,nline=0,testCases=0,number=0,x=0,y=0;
        boolean test=true;
        HashMap<Integer,HashMap<Integer,Int>> ycount=null;
        Point[] points=null;
        while((cread=System.in.read(arr))>-1)
        {
            boolean end=false;
            for(int i=0;i<cread;i++)
            {
                b=arr[i];
                //System.out.println(b);
                if(b!=10&&b!=32&&b!=13)
                {
                    number=number*10+b-48;
                }
                else if(b==10)
                {

                    if(test)
                    {
                        testCases=number;
                        if(testCases==0)
                        {
                            end=true;
                            break;
                        }
                        points=new Point[testCases];
                        ycount=new HashMap<Integer, HashMap<Integer,Int>>();
                        number=0;
                        test=false;
                        nline=0;
                        //System.out.println("Testcase : "+ testCases);
                    }
                    else
                    {
                        //System.out.println("Y : "+number);
                        y=number;
                        //points[nline][1]=number;
                        number=0;


                        points[nline]=new Point();
                        points[nline].x=x;
                        points[nline].y=y;

                        nline++;
						/*
						LinkedList<Integer> list=null;
						if(map.get(x)==null)
						{
							list=new LinkedList<Integer>();
							map.put(x, list);
						}
						if(list==null)
						{
							list=map.get(x);
						}
						if(list.size()==1)
						{
							if(list.getFirst().intValue()<y)
							{
								list.addLast(y);
							}
							else
							{
								list.addFirst(y);
							}
						}
						else
						{
							list.add(y);
						}
						if(list.size()==2)
						{
							HashMap<Integer,Int> diff=null;
							int y1=list.getFirst();
							int y2=list.getLast();
							if(ycount.get(y1)==null)
							{
								diff=new HashMap<Integer, Int>();
								ycount.put(y1, diff);
							}
							if(diff==null)
							{
								diff=ycount.get(y1);
							}
							if(diff.get(y2)==null)
							{
								diff.put(y2, new Int());
							}
							diff.get(y2).add();
						}
						*/
                        if(nline==testCases)
                        {
							/*
							long total=0;
							Iterator<Entry<Integer,HashMap<Integer,Int>>> it1=ycount.entrySet().iterator();
							while(it1.hasNext())
							{
								HashMap<Integer,Int> map1=it1.next().getValue();
								Iterator<Entry<Integer,Int>> it2=map1.entrySet().iterator();
								while(it2.hasNext())
								{
									long count=it2.next().getValue().getInt();
									total+=count*(count-1)/2;
								}
							}
							System.out.println(total);
							*/
                            //System.out.println(System.currentTimeMillis());
                            Arrays.sort(points);
                            //System.out.println(System.currentTimeMillis());
                            //System.out.println(System.currentTimeMillis());

                            for(int j=0;j<nline-1;j++)
                            {
                                if(points[j].x==points[j+1].x)
                                {
                                    HashMap<Integer,Int> diff=null;
                                    int y1=points[j].y;
                                    int y2=points[j+1].y;
                                    if(ycount.get(y1)==null)
                                    {
                                        diff=new HashMap<Integer, Int>();
                                        ycount.put(y1, diff);
                                    }
                                    if(diff==null)
                                    {
                                        diff=ycount.get(y1);
                                    }
                                    if(diff.get(y2)==null)
                                    {
                                        diff.put(y2, new Int());
                                    }
                                    diff.get(y2).add();
                                }
                            }

                            //System.out.println(System.currentTimeMillis());
                            long total=0;

                            Iterator<Entry<Integer,HashMap<Integer,Int>>> it1=ycount.entrySet().iterator();
                            while(it1.hasNext())
                            {
                                HashMap<Integer,Int> map1=it1.next().getValue();
                                Iterator<Entry<Integer,Int>> it2=map1.entrySet().iterator();
                                while(it2.hasNext())
                                {
                                    long count=it2.next().getValue().getInt();
                                    total+=count*(count-1)/2;
                                }
                            }
                            //System.out.println(System.currentTimeMillis());
                            System.out.println(total);
                            test=true;
                        }
                    }
                }
                else if(b==32)
                {
                    //System.out.println("X : "+number);
                    //x=number;
                    x=number;
                    number=0;
                }
            }
            if(end)
            {
                break;
            }
        }
    }
}
