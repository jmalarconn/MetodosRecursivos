class metodosrecursivos {

    // 1. Factorial de un número
    long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // 2. Torres de Hanoi
    String torresHanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            return "Mover disco 1 de " + origen + " a " + destino + "\n";
        }

        String movimientos = "";
        movimientos += torresHanoi(n - 1, origen, auxiliar, destino);
        movimientos += "Mover disco " + n + " de " + origen + " a " + destino + "\n";
        movimientos += torresHanoi(n - 1, auxiliar, destino, origen);

        return movimientos;
    }

    // 3. Búsqueda binaria en un arreglo ordenado
    int busquedaBinaria(int[] arr, int objetivo, int inicio, int fin) {
        if (inicio > fin) return -1; // No encontrado

        int medio = inicio + (fin - inicio) / 2;

        if (arr[medio] == objetivo) return medio;

        if (arr[medio] > objetivo) {
            return busquedaBinaria(arr, objetivo, inicio, medio - 1);
        } else {
            return busquedaBinaria(arr, objetivo, medio + 1, fin);
        }
    }

    // 4. Verificar si un número es primo
    boolean esPrimo(int n, int divisor) {
        if (n <= 2) return (n == 2);
        if (n % divisor == 0) return false;
        if (divisor * divisor > n) return true;

        return esPrimo(n, divisor + 1);
    }

    // 5. Sucesión de Collatz
    String collatz(int n) {
        if (n == 1) return "1";

        if (n % 2 == 0) {
            return n + " -> " + collatz(n / 2);
        } else {
            return n + " -> " + collatz(3 * n + 1);
        }
    }

    // Métodos que se mantienen igual
    String cuentaRegresiva(int n) {
        if (n == 0) return "0";
        return n + ", " + cuentaRegresiva(n-1);
    }

    double potenciaRapida(double base, int exponente) {
        if (exponente == 0) return 1;
        if (exponente % 2 == 0) {
            double mitad = potenciaRapida(base, exponente / 2);
            return mitad * mitad;
        } else {
            return base * potenciaRapida(base, exponente - 1);
        }
    }

    int sumaArreglo(int[] arr, int n) {
        if (n <= 0) return 0;
        return sumaArreglo(arr, n-1) + arr[n-1];
    }
}