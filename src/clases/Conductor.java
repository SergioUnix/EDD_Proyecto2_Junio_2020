/**
 *
 * @author Alejandro Lorenty
 */
package clases;

public class Conductor {

    private long DPI;
    private String nombres;
    private String apellidos;
    private char licencia;
    private String genero;
    private int telefono;
    private String direccion;

    public Conductor() {
        this.DPI = 0;
        this.nombres = null;
        this.apellidos = null;
        this.licencia = 'C';
        this.genero = null;
        this.telefono = 0;
        this.direccion = null;
    }

    public Conductor(long DPI, String nombres, String apellidos, char licencia, String genero, int telefono, String direccion) {
        this.DPI = DPI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.licencia = licencia;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public long getDPI() {
        return DPI;
    }

    public void setDPI(long DPI) {
        this.DPI = DPI;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getLicencia() {
        return licencia;
    }

    public void setLicencia(char licencia) {
        this.licencia = licencia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Conductor{" + "DPI=" + DPI + ", nombres=" + nombres + ", apellidos=" + apellidos + ", licencia=" + licencia + ", genero=" + genero + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
