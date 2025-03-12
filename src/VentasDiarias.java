/*
 * @author Mateo Cuenca
 * @version 1.0
 */
import java.util.Scanner;

public class VentasDiarias {
    private double[] precios;
    private int[] cantidades;

    public VentasDiarias(int numReferencias) {
        precios = new double[numReferencias];
        cantidades = new int[numReferencias];
    }

    public void registrarVentas(Scanner scanner) {
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Precio del producto " + (i + 1) + ": ");
            precios[i] = scanner.nextDouble();
            System.out.print("Cantidad vendida del producto " + (i + 1) + ": ");
            cantidades[i] = scanner.nextInt();
        }
    }

    public int totalUnidades() {
        int total = 0;
        for (int cantidad : cantidades) {
            total += cantidad;
        }
        return total;
    }

    public double precioPromedio() {
        double suma = 0;
        for (double precio : precios) {
            suma += precio;
        }
        return suma / precios.length;
    }

    public double ventasTotales() {
        double total = 0;
        for (int i = 0; i < precios.length; i++) {
            total += precios[i] * cantidades[i];
        }
        return total;
    }

    public int productosSobreUmbral(double umbral) {
        int contador = 0;
        for (int i = 0; i < precios.length; i++) {
            if (precios[i] * cantidades[i] >= umbral) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número de productos vendidos: ");
        int numReferencias = scanner.nextInt();

        VentasDiarias ventas = new VentasDiarias(numReferencias);
        ventas.registrarVentas(scanner);

        System.out.println("Total unidades vendidas: " + ventas.totalUnidades());
        System.out.println("Precio promedio: " + ventas.precioPromedio());
        System.out.println("Ventas totales: " + ventas.ventasTotales());

        System.out.print("Ingrese umbral de ventas: ");
        double umbral = scanner.nextDouble();
        System.out.println("Productos sobre umbral: " + ventas.productosSobreUmbral(umbral));
    }
}
