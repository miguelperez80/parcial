package taller.main;

public class Automovil extends Vehiculo {
    private int numeroPuertas;
    private int hora_salida;

    public Automovil(String marca, String modelo, String placa, int hora_llegada, int numeroPuertas, int hora_salida) {
        super(marca, modelo, placa, hora_llegada);
        this.numeroPuertas = numeroPuertas;
        this.hora_salida = hora_salida;
    }

    public void setHora_salida(int hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getHora_salida() {
        return hora_salida;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
}

    

   

    
    
   
    
   
    
    


