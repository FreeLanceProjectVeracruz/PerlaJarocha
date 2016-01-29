package model.jhernandez.enums;

/**
 *
 * @author WIN 8
 */
public enum Images {

    /**
     *
     */
    Candado("/mx/com/jhernandez/images/candado.png"),
    /**
     *
     */
    Usuario("/mx/com/jhernandez/images/usuario.png"),
    Empleados("/mx/com/jhernandez/images/Office-Client-Male-Light.png"),
    Proveedores("/mx/com/jhernandez/images/Groups-Meeting-Light.png"),
    Clientes("/mx/com/jhernandez/images/Folder-Group.png"),
    Servicios("/mx/com/jhernandez/images/User-Files.png"),
    Bebidas("/mx/com/jhernandez/images/Beer.png"),
    Alimentos("/mx/com/jhernandez/images/Salad.png"),
    Otros("/mx/com/jhernandez/images/Cigarette.png"),
    ComprasR("/mx/com/jhernandez/images/empty-shopping-cart.png"),
    ComprasC("/mx/com/jhernandez/images/shop-cart-exclude.png"),
    VentasR("/mx/com/jhernandez/images/Earning-statement.png"),
    VentasC("/mx/com/jhernandez/images/delete-file.png"),
    VentasE("/mx/com/jhernandez/images/Clients.png"),
    Stock("/mx/com/jhernandez/images/Packing-1.png"),
    CierreCaja("/mx/com/jhernandez/images/Order-history.png"),
    Promociones("/mx/com/jhernandez/images/New-Year-Party.png"),
    Compra("/mx/com/jhernandez/images/shopping-cart.png"),
    Venta("/mx/com/jhernandez/images/Cash-register.png"),
    Inventario("/mx/com/jhernandez/images/Inventory.png"),
    Mantenimiento("/mx/com/jhernandez/images/maintenance.png"),
    ExportarPDF("/mx/com/jhernandez/images/document-pdf.png"),
    ExportarExcel("/mx/com/jhernandez/images/document-excel.png"),
    CambiarClave("/mx/com/jhernandez/images/Keys.png"),
    Impresora("/mx/com/jhernandez/images/Printer.png"),
    CambiarSesion("/mx/com/jhernandez/images/Log-Out.png"),
    Salir("/mx/com/jhernandez/images/Apps-session-logout.png"),
    Logo("/mx/com/jhernandez/images/Beer-logo.png"),
    BasedeDatos("/mx/com/jhernandez/images/Misc-Upload-Database.png");

    String imagefilename;

    Images(String name) {
        imagefilename = name;
    }

    /**
     *
     * @return
     */
    public String getRuta() {
        return imagefilename;
    }
}
