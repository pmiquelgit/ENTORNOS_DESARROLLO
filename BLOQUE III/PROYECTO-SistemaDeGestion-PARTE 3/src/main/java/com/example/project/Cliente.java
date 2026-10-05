package com.example.project;

/**
 * Represents a customer of the shop, with contact data, seniority,
 * VIP status and country.
 */
public class Cliente {
    
    /** Full name of the customer. Never null or empty at creation. */
    private String nombre;
    /** Email address of the customer. */
    private String correo;
    /** Postal address of the customer. */
    private String direccion;
    /** Number of years the customer has been registered. */
    private int anyosAntiguedad;
    /** Whether the customer has VIP status. */
    private boolean esVip;
    /** Country of the customer, used to calculate shipping costs. */
    private String pais;

    /**
     * Creates a customer with all its attributes.
     *
     * @param nombre           the name of the customer, must not be null or empty
     * @param correo           the email address
     * @param direccion        the postal address
     * @param anyosAntiguedad  years the customer has been registered
     * @param esVip            whether the customer is VIP
     * @param pais             the country of the customer
     * @throws NullPointerException if {@code nombre} is null or empty
     */
    // Nuevo constructor para cliente con los atributos nuevos que me pide
    public Cliente(String nombre, String correo, String direccion, int anyosAntiguedad, boolean esVip, String pais) {
        if (nombre == null || nombre.isEmpty()) {
            throw new NullPointerException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.anyosAntiguedad = anyosAntiguedad;
        this.esVip = esVip;
        this.pais = pais;


    }

    /**
     * Creates a customer with default values for the newer attributes:
     * 0 years of seniority, not VIP and country "ESPAÑA".
     *
     * @param nombre     the name of the customer, must not be null or empty
     * @param correo     the email address
     * @param direccion  the postal address
     * @throws NullPointerException if {@code nombre} is null or empty
     */
    // Mantengo el constructor antiguo para que los test no colapsen
    // Este constructor no tiene los atributos nuevos que he añadido
    public Cliente(String nombre, String correo, String direccion){

        //HE TENIDO QUE CORREGIR ESTE CONSTRUCTOR PARA QUE SONARCUBE FUNCIONASE EN LA PARTE 3 DEL PROYECTO
        this(nombre, correo, direccion, 0, false, "ESPAÑA");

    }

    /**
     * Gets the name of the customer.
     *
     * @return the name of the customer
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Sets the name of the customer.
     *
     * @param nombre the new name
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the email address of the customer.
     *
     * @return the email address
     */
    public String getCorreo() {
        return this.correo;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param correo the new email address
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Gets the postal address of the customer.
     *
     * @return the postal address
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Sets the postal address of the customer.
     *
     * @param direccion the new postal address
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets the years the customer has been registered.
     *
     * @return the years of seniority
     */
    public int getAnyosAntiguedad() {
        return this.anyosAntiguedad;
    }

    /**
     * Sets the years the customer has been registered.
     *
     * @param anyosAntiguedad the new years of seniority
     */
    public void setAnyosAntiguedad(int anyosAntiguedad) {
        this.anyosAntiguedad = anyosAntiguedad;
    }

    /**
     * Checks whether the customer has VIP status.
     *
     * @return {@code true} if the customer is VIP, {@code false} otherwise
     */
    public boolean isEsVip() {
        return this.esVip;
    }

    /**
     * Checks whether the customer has VIP status (alternative getter).
     *
     * @return {@code true} if the customer is VIP, {@code false} otherwise
     */
    public boolean getEsVip() {
        return this.esVip;
    }

    /**
     * Sets the VIP status of the customer.
     *
     * @param esVip {@code true} to make the customer VIP
     */
    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }

    /**
     * Gets the country of the customer.
     *
     * @return the country
     */
    public String getPais() {
        return this.pais;
    }

    /**
     * Sets the country of the customer.
     *
     * @param pais the new country
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Returns a readable description of the customer with its name and email.
     *
     * @return a string with the name and the email of the customer
     */
    //MÉTODO "toString" para mostrar la información del cliente sobreescribiendo
    //el método por este con "@Override"
    @Override
    public String toString()
    {
        return "Nombre: " + this.nombre + " - Correo: " + this.correo;
    }
}
