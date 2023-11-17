
package taller.main;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String placa;
    private int hora_llegada;

    public Vehiculo(String marca, String modelo, String placa, int hora_llegada) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.hora_llegada = hora_llegada;
    }

    public int getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(int hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int calcularGanancia(int totalVehiculos) {
        int gananciaBase = 0;

        if (this instanceof Motocicleta) {
            gananciaBase = 5000;
        } else if (this instanceof Automovil) {
            gananciaBase = 10000;
        }

        return gananciaBase * totalVehiculos;
    }

    void setHora_salida(int hora_salida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
