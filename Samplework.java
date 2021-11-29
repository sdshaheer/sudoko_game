/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplework;
import source.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Framework extends JFrame implements ActionListener{
    JTextField f[]=new JTextField[81];
    ArrayList<Integer[][]> array=new ArrayList<>();
    Container c;
    Integer a[][]=new Integer[9][9];
    Integer finalarray[][]=new Integer[9][9];
    int count;
    JButton btn;
    JButton next;
    JTextField output;
    String out="";
    public Framework(ArrayList arr){
        c=this.getContentPane();
        array=arr;
        a=array.get(0);
        c.setLayout(null);
        int x=0;
        int y=0;
        int k=5;
        int z=0;
        int r=0;
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                f[r]=new JTextField();
                f[r].setBounds(200+30*x+k,200+30*y+z,30,30);
                f[r].addActionListener(this);
                x++;
                if(x%9==0){
                    y++;
                    x=0;
                    k=0;
                }
                if(x%3==0 && x!=9)
                    k+=5;
                if(y==3)
                    z=5;
                if(y==6)
                  z=10;
                c.add(f[r++]);
            }   
        } 
        btn=new JButton("SOLVE");
        next=new JButton("Next");
        output=new JTextField();
        next.setBounds(350,600,75,50);
        btn.setBounds(250,600,75,50);
        next.addActionListener(this);
        output.setBounds(200,500,290,30);
        btn.addActionListener(this);
        c.add(next);
        c.add(btn);
        c.add(output);
        fill(a);
    }
    public void fill(Integer a[][]){
        int s=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(a[i][j]!=0){
                    f[s].setText(Integer.toString(a[i][j]));
                    f[s].setBackground(Color.GRAY);
                }
                else{
                    f[s].setText(null);
                    f[s].setBackground(Color.WHITE);
                }
                s++;
            }
        }
        solve(a);
    }
    public void actionPerformed(ActionEvent e){
        System.out.println("hi");
        if(e.getSource()==next){
            out="";
            output.setText(null);
            a=array.get(++count%3);
            if(count%3==0){
                restart();
                a=array.get(0);
            }
            fill(a);
            
        }
        else if(e.getSource()==btn)
            start(a);
        else{
            int r=0;
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++) {
                    if(e.getSource()==f[r]){
                        if(!(f[r].getText().equals(Integer.toString(a[i][j])))){//code check here.........
                            out+=Character.toString((char)'\u2718');
                            output.setText(out);
                        }
                        else{
                            out+=Character.toString((char)'\u2714');
                            output.setText(out);
                        }
                    }
                    System.out.println("hi");
                    r++;
                }
            }
                
        }
    }
    public void solve(Integer arr[][]){
        Code c=new Code();
        c.solve(arr);
    }
    public void start(Integer array[][]){
        int k=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                f[k++].setText(Integer.toString(array[i][j]));
            }
        }  
    }
    public void restart(){
        array.clear();
        Integer array1[][]={
            {6,5,0,8,7,3,0,9,0},
            {0,0,3,2,5,0,0,0,8},
            {9,8,0,1,0,4,3,5,7},
            {1,0,5,0,0,0,0,0,0},
            {4,0,0,0,0,0,0,0,2},
            {0,0,0,0,0,0,5,0,3},
            {5,7,8,3,0,1,0,2,6},
            {2,0,0,0,4,8,9,0,0},
            {0,9,0,6,2,5,0,8,1}};
        
        Integer array2[][]={ {3,0,6,5,0,8,4,0,0}, 
         {5,2,0,0,0,0,0,0,0}, 
         {0,8,7,0,0,0,0,3,1}, 
         {0,0,3,0,1,0,0,8,0}, 
         {9,0,0,8,6,3,0,0,5}, 
         {0,5,0,0,9,0,6,0,0}, 
         {1,3,0,0,0,0,2,5,0}, 
         {0,0,0,0,0,0,0,7,4}, 
         {0,0,5,2,0,6, 3,0,0}};
        
        Integer array3[][]={
        {8,0,0,0,0,0,0,0,0},
        {0,0,3,6,0,0,0,0,0},
        {0,7,0,0,9,0,2,0,0},
        {0,5,0,0,0,7,0,0,0},
        {0,0,0,0,4,5,7,0,0},
        {0,0,0,1,0,0,0,3,0},
        {0,0,1,0,0,0,0,6,8},
        {0,0,8,5,0,0,0,1,0},
        {0,9,0,0,0,0,4,0,0}};

        array.add(array1);
        array.add(array2);
        array.add(array3);
    }
}

public class Samplework {

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer[][]> arr=new ArrayList<>();
        Integer array1[][]={
            {6,5,0,8,7,3,0,9,0},
            {0,0,3,2,5,0,0,0,8},
            {9,8,0,1,0,4,3,5,7},
            {1,0,5,0,0,0,0,0,0},
            {4,0,0,0,0,0,0,0,2},
            {0,0,0,0,0,0,5,0,3},
            {5,7,8,3,0,1,0,2,6},
            {2,0,0,0,4,8,9,0,0},
            {0,9,0,6,2,5,0,8,1}};
        Integer array2[][]={ {3,0,6,5,0,8,4,0,0}, 
         {5,2,0,0,0,0,0,0,0}, 
         {0,8,7,0,0,0,0,3,1}, 
         {0,0,3,0,1,0,0,8,0}, 
         {9,0,0,8,6,3,0,0,5}, 
         {0,5,0,0,9,0,6,0,0}, 
         {1,3,0,0,0,0,2,5,0}, 
         {0,0,0,0,0,0,0,7,4}, 
         {0,0,5,2,0,6, 3,0,0}};
        Integer array3[][]={
        {8,0,0,0,0,0,0,0,0},
        {0,0,3,6,0,0,0,0,0},
        {0,7,0,0,9,0,2,0,0},
        {0,5,0,0,0,7,0,0,0},
        {0,0,0,0,4,5,7,0,0},
        {0,0,0,1,0,0,0,3,0},
        {0,0,1,0,0,0,0,6,8},
        {0,0,8,5,0,0,0,1,0},
        {0,9,0,0,0,0,4,0,0}};

        arr.add(array1);
        arr.add(array2);
        arr.add(array3);
        Framework frame=new Framework(arr);
        frame.setVisible(true);
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

