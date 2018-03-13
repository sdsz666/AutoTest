package com.ymt.apiTest;

public class testBubbleSort {

    public static void BubbleSort(){
        int temp;
        int[] array  ={33,23,44,52,11,6,24,57};

        for (int i = 0;i <array.length;i ++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }
        System.out.println(array.length);


    }


    public static void SelectSort(){
        int max;
        int temp;
        int[] array  ={33,23,44,52,11,6,24,57};
        for (int i=0;i<array.length;i++){
            max=array[i];
            for(int j=array.length-1;j>i;j--){
                if(array[i]<array[j]){
                    temp=array[j];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }

        }
    }

    public static void InsertSort(){
        int[] array  ={1,2,5,6,7,8,9,3,10};
        int count=0;
        int insertNum;
        for (int i=1;i<array.length;i++){
            insertNum=array[i];
            for (int j=i-1;j>=0;j--){
                //前面的大于后面的，则调换，即小的排在前面
                if (array[j]>insertNum){
                    array[j+1]=array[j];
                    count++;
                    System.out.println("排序次数+1");
                }else {
                    break;
                }
                array[j]=insertNum;
            }
        }
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("排序次数为"+count);

    }


    public static void main(String args[]){
        //BubbleSort();
        InsertSort();

    }

}
//