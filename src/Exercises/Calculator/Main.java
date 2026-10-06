package Exercises.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operations operation = new Operations();
        Menu consola = new Menu();
        int cont=0;

        while(cont!=5){

            consola.menuPrincipal();
            cont=sc.nextInt();

            if(cont == 1){
                System.out.println(" ingrese numero 1 y 2  :");
                operation.toAdd(sc.nextDouble(),sc.nextDouble());
            }else  if(cont == 2){
                System.out.println(" ingrese numero 1 y 2  :");
                operation.subtraction(sc.nextDouble(),sc.nextDouble());
            }else if(cont == 3){
                System.out.println(" ingrese numero 1 y 2  :");
                operation.multiplicacion(sc.nextDouble(),sc.nextDouble());
            }else  if(cont == 4){
                System.out.println(" ingrese numero 1 y 2  :");
                operation.division(sc.nextDouble(),sc.nextDouble());
            }else{
                System.out.println("#######################################");
                System.out.println("error intente de nuevo");
                System.out.println("#######################################");
                System.out.println();
            }

            consola.menuOperations();
            cont=sc.nextInt();
        }

    }
}

