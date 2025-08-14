import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean corriendo = true;
        while(corriendo) {
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("Conversor de Soles a: ");
            System.out.println("1. Dolares");
            System.out.println("2. Euros");
            System.out.println("3. Yenes");
            System.out.println("4. Rublos");
            System.out.println("5. Calculadora");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            double monto;
            double montoFinal;
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el monto en soles a convertir:");
                    monto= scanner.nextDouble();
                    montoFinal= monto*0.28;
                    System.out.println("-> "+monto+" Soles a Dolares es: "+ montoFinal);
                    break;
                case 2:
                    System.out.println("Ingrese el monto en soles a convertir:");
                    monto= scanner.nextDouble();
                    montoFinal= monto*0.24;
                    System.out.println("-> "+monto+" Soles a Euros es: "+ montoFinal);
                    break;
                case 3:
                    System.out.println("Ingrese el monto en soles a convertir:");
                    monto= scanner.nextDouble();
                    montoFinal= monto*42.02;
                    System.out.println("-> "+monto+" Soles a Yenes es: "+ montoFinal);
                    break;
                case 4:
                    System.out.println("Ingrese el monto en soles a convertir:");
                    monto= scanner.nextDouble();
                    montoFinal= monto*22.51;
                    System.out.println("-> "+monto+" Soles a Rublos es: "+ montoFinal);
                    break;
                case 5:
                    while(true){
                        System.out.println("Bienvenido a la calculadora");
                        System.out.println("1. Suma");
                        System.out.println("2. Resta");
                        System.out.println("3. Multiplicacion");
                        System.out.println("4. Division");
                        System.out.println("5. Salir al menu principal");
                        System.out.println("6. Salir definitivamente");
                        int opcion2= scanner.nextInt();
                        if(opcion2==5){
                            System.out.println("Volviendo al menu prinpal...");
                            break;
                        }
                        else if(opcion2==6){
                            System.out.println("Hasta Luego :(");
                            corriendo= false;
                            break;
                        }
                        double a,b;
                        System.out.println("Ingrese el primer digito:");
                        a= scanner.nextDouble();
                        System.out.println("Ingrese el segundo digito:");
                        b= scanner.nextDouble();
                        switch (opcion2){
                            case 1:
                                System.out.println(a+" + "+b+" = "+(a+b));
                                break;
                            case 2:
                                System.out.println(a+" - "+b+" = "+(a-b));
                                break;
                            case 3:
                                System.out.println(a+" x "+b+" = "+(a*b));
                                break;
                            case 4:
                                if(b==0){
                                    System.out.println("Error: Division por cero, vuelve a intentarlo");
                                    break;
                                }
                                System.out.println(a+" / "+b+" = "+(a/b));
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Hasta Luego :(");
                    corriendo=false;
                    break;
                default:
                    break;
            }
        }
    }
}