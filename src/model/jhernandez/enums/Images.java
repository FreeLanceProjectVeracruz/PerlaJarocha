package model.jhernandez.enums;

/**
 *
 * @author WIN 8
 */
public enum Images {

    Candado("/view/jhernandez/images/candado.png"),
    Usuario("/view/jhernandez/images/usuario.png"),
    Empleados("/view/jhernandez/images/Office-Client-Male-Light.png"),
    Proveedores("/view/jhernandez/images/Groups-Meeting-Light.png"),
    Clientes("/view/jhernandez/images/Folder-Group.png"),
    Servicios("/view/jhernandez/images/User-Files.png"),
    Bebidas("/view/jhernandez/images/Beer.png"),
    Alimentos("/view/jhernandez/images/Salad.png"),
    Otros("/view/jhernandez/images/Cigarette.png"),
    ComprasR("/view/jhernandez/images/empty-shopping-cart.png"),
    ComprasC("/view/jhernandez/images/shop-cart-exclude.png"),
    VentasR("/view/jhernandez/images/Earning-statement.png"),
    VentasC("/view/jhernandez/images/delete-file.png"),
    VentasE("/view/jhernandez/images/Clients.png"),
    Stock("/view/jhernandez/images/Packing-1.png"),
    CierreCaja("/view/jhernandez/images/Order-history.png"),
    Promociones("/view/jhernandez/images/New-Year-Party.png"),
    Compra("/view/jhernandez/images/shopping-cart.png"),
    Venta("/view/jhernandez/images/Cash-register.png"),
    Inventario("/view/jhernandez/images/Inventory.png"),
    Mantenimiento("/view/jhernandez/images/maintenance.png"),
    ExportarPDF("/view/jhernandez/images/document-pdf.png"),
    ExportarExcel("/view/jhernandez/images/document-excel.png"),
    CambiarClave("/view/jhernandez/images/Keys.png"),
    Impresora("/view/jhernandez/images/Printer.png"),
    CambiarSesion("/view/jhernandez/images/Log-Out.png"),
    Salir("/view/jhernandez/images/Apps-session-logout.png"),
    Logo("/view/jhernandez/images/Beer-logo.png"),
    BasedeDatos("/view/jhernandez/images/Misc-Upload-Database.png"),
    Agregar("/view/jhernandez/images/agregar.png"), 
    Eliminar("/view/jhernandez/images/remover.png"), 
    Buscar("/view/jhernandez/images/buscar.png"), 
    Modificar("/view/jhernandez/images/editar.png"), 
    NoPhoto("/view/jhernandez/images/noFoto.png");

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
