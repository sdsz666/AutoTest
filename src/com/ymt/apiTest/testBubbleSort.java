package apiTest;

public class testBubbleSort {

    public static void BubbleSort(){
        int temp;
        int[] array  =new int[]{33,23,44,52,11,6,24,57};

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
        int[] array  =new int[]{33,23,44,52,11,6,24,57};
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

    public static void main(String args[]){
        BubbleSort();

    }

}
//