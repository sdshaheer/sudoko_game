
package source;

import java.util.HashMap;

public class Code {
    public int index(int a){
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(2,0);
        h.put(5,3);
        h.put(8,6);
        if(a<=2)
            return h.get(2);
        else if(a<=5)
            return h.get(5);
        else
            return h.get(8);
    }

    public static int[] checkzero(Integer a[][]){
        int arr[]={-1,-1};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(a[i][j]==0){
                    arr[0]=i;
                    arr[1]=j;
                    return arr;
                }    
            }
        }
        return arr;
    }
    public boolean solve(Integer array[][]){
        int arr[]=checkzero(array);
        int row =arr[0];
        int col=arr[1];
        if(row==-1)
            return true;
        for (int i = 1; i < 10; i++) {
            if(safe(array,row,col,i)){
                array[row][col]=i;
                if(solve(array))
                    return true;
                else
                    array[row][col]=0;
            }
        }
        return false;
    }
    public boolean safe(Integer a[][],int i,int j,int value){
        //checking row
        for (int k = 0; k < 9; k++) {
            if(a[i][k]==value)
                return false;
        }
        //checking coloumn
        for (int k = 0; k < 9; k++) {
            if(a[k][j]==value)
                return false;
        }
        //3x3 grid
        int row=index(i);
        int col=index(j);
        for (int k = row; k < row+3; k++) {
            for (int l = col; l < col+3; l++) {
                if(a[k][l]==value)
                    return false;
            }
        }
        
      return true;  
    }
}
