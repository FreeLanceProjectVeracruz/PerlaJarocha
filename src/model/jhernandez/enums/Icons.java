package model.jhernandez.enums;

/**
 *
 * @author WIN 8
 */
public enum Icons {

    BulletError("/mx/com/jhernandez/icons/bullet_error.png"),
    Help("/mx/com/jhernandez/icons/Help-icon.png"),
    Bold("/mx/com/jhernandez/icons/text_bold.png"),
    Italic("/mx/com/jhernandez/icons/text_italic.png"),
    Underline("/mx/com/jhernandez/icons/text_underline.png"),
    Printer("/mx/com/jhernandez/icons/printer.png"),
    Save("/mx/com/jhernandez/icons/database_save.png"),
    ZoomIn("/mx/com/jhernandez/icons/magnifier_zoom_in.png"),
    ZoomOut("/mx/com/jhernandez/icons/magifier_zoom_out.png");

    String iconfilename;

    Icons(String name) {
        iconfilename = name;
    }

    /**
     *
     * @return
     */
    public String getRuta() {
        return iconfilename;
    }
}
