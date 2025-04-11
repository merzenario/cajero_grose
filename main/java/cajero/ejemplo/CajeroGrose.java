package cajero.ejemplo;
import java.util.Scanner;

public class CajeroGrose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int PIN_CORRECTO = 1234;
        double saldo = 100000;
        int intentos = 0;
        boolean cuentaBloqueada = false;

        //autenticacion segun intentos
        while(intentos < 3){
            System.out.println("ingrese su PIN: ");
            int pinIngresado = scanner.nextInt();

            if(pinIngresado == PIN_CORRECTO){
                System.out.println("!!Welcome Gonorr***¡¡");
                break;
            }else{
                System.out.println("!!PIN incorrecto¡¡" +intentos);
            }
            if(intentos == 3);{
                cuentaBloqueada = true;
                System.out.println("!!Cuenta Bloqueado¡¡");
            }

        }
        if(cuentaBloqueada){
            scanner.close();
            return;
        }
        //menu
        int opcion;
        do { 
            System.out.println("\n Bienvenido al cajero gono****");
            System.out.println("1. Consultar Chichigua");
            System.out.println("2. Retirar los pesos");
            System.out.println("3. Depositar");
            System.out.println("4. Transferir");
            System.out.println("5. Cambio de clave");
            System.out.println("6. Open the parch");
            opcion = scanner.nextInt();

            ///opciones
            switch(opcion){
                case 1:
                    System.out.println("Ay mari*** que miseria: "+saldo);
                    break;
                case 2:
                    System.out.println("Cuanto quiere?: ");
                    double retiro = scanner.nextDouble();
                    if(retiro > 0 && retiro <= saldo){
                        saldo-= retiro;
                        System.out.println("Que chimb**, lo que queda es: "+saldo);
                    }else{
                        System.out.println("Despertate pues!! apenas tenes: "+saldo);
                    }    
                    break;
                case 3:
                    System.out.println("Cuanto depositas?: ");
                    double deposito = scanner.nextDouble();
                    if(deposito > 0){
                        saldo+= deposito;
                        System.out.println("Deposito exitoso!!! Nuevo saldo: "+saldo);
                    } 
                    break;
                case 4:       // new
                    System.out.println("Numero de cuenta pues: ");
                    int cuenta = scanner.nextInt();  
                    System.out.println("Cuanto va a mandar: ");
                    double transfer = scanner.nextDouble(); 
                    if(transfer > 0 && transfer <= saldo){
                        saldo-= transfer;
                        System.out.println("Que chimb**, lo que queda es: "+saldo);
                    }else{
                        System.out.println("Despertate pues!! apenas tenes: "+saldo);
                    }    
                    break;
                case 5:
                    System.out.println("Ingrese su clave pues: ");
                    int pinOld = scanner.nextInt();

                    if(pinOld == PIN_CORRECTO){
                        System.out.println("Cambie la clave pues: ");
                        int pinNew = scanner.nextInt();
                        System.out.println("Otra vez, pa que no se el olvide: ");
                        int pinEnd = scanner.nextInt();
                        if(pinEnd == pinNew){
                        System.out.println("!!Listo el pollo¡¡");
                        }
                        break;
                    }else{
                    System.out.println("!!PIN incorrecto¡¡" +intentos);
                    }
                    return;
                case 6:     
                    System.out.println("Nos pillamos!!");
                default:
                    System.out.println("Avispate pues!! eso no es una opcion!!");
            }
        } while (opcion!= 6);
        scanner.close();
       }
}