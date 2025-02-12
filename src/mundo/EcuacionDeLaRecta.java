package mundo;

public class EcuacionDeLaRecta {
    private double x1, y1, x2, y2;

    public EcuacionDeLaRecta(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Calcular pendiente (m = (y2 - y1) / (x2 - x1))
    public double calcularPendiente() {
        if (x2 == x1) {
            throw new ArithmeticException("División por cero: x1 y x2 no pueden ser iguales.");
        }
        return (y2 - y1) / (x2 - x1);
    }

    // Mostrar la ecuación de la recta en la forma y = mx + b
    public String mostrarEcuacion() {
        double pendiente = calcularPendiente();
        double b = y1 - pendiente * x1; // b = y1 - mx1
        return "y = " + pendiente + "x + " + b;
    }
}
