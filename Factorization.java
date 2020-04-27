package com.company;

import javax.swing.*;

import java.awt.event.*;
import java.awt.FlowLayout;

public class Factorization extends JFrame{
    JTextField firstField;

    public Factorization()
    {
        super("Факторизация");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        firstField = new JTextField(10);

        firstField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(firstField.getText()) % 2 == 0) {
                    JOptionPane.showMessageDialog(Factorization.this,
                            "Ошибка,введите другое число ");
                } else {
                    int[] arr = factorization(Integer.parseInt(firstField.getText()));

                    JOptionPane.showMessageDialog(Factorization.this,
                            "Множители числа " + firstField.getText() + ": " + Integer.toString(arr[0] )+ ", " + Integer.toString(arr[1]));
                }
            }
        });

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(new JLabel("Введите натуральное нечетное число"));
        contents.add(firstField);
        contents.add(new JLabel("Нажмите Enter"));
        setContentPane(contents);
        setSize(400, 100);
        setVisible(true);
    }

    public static int[] factorization(int number){
        int[] myArr = new int[2];
        int s = (int) Math.sqrt(number);
        if( Math.pow(s, 2) == number){
            myArr[0] = s;
            myArr[1] = s;
            return myArr;
        } else {
            int x = s;
            double l = 0;
            for (int k = 0; k < number / 2; k++) {
                l = Math.pow(x, 2) - number;
                int ll = (int)Math.sqrt(l);
                if(Math.sqrt(l) == (double) ll){
                    myArr[0] = x + ll;
                    myArr[1] = x - ll;
                }else{
                    x++;
                }
            }
            for (int value : myArr) {
                System.out.println(value);
            }
            return myArr;
        }

    }
    public static void main(String[] args) {
        new Factorization();
    }
}
