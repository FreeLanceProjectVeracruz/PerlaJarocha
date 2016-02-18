package model.jhernandez.enums;

/**
 *
 * @author WIN 8
 */
public enum Icons {

    BulletError("/view/jhernandez/icons/bullet_error.png"),
    Help("/view/jhernandez/icons/Help-icon.png"),
    Bold("/view/jhernandez/icons/text_bold.png"),
    Italic("/view/jhernandez/icons/text_italic.png"),
    Underline("/view/jhernandez/icons/text_underline.png"),
    Printer("/view/jhernandez/icons/printer.png"),
    Save("/view/jhernandez/icons/database_save.png"),
    ZoomIn("/view/jhernandez/icons/magnifier_zoom_in.png"),
    ZoomOut("/view/jhernandez/icons/magifier_zoom_out.png"),
    GoFirst("/view/jhernandez/icons/go-first.png"),
    GoLast("/view/jhernandez/icons/go-last.png"),
    GoNext("/view/jhernandez/icons/go-next.png"),
    GoPrevious("/view/jhernandez/icons/go-previous.png"),
    ViewRefresh("/view/jhernandez/icons/view-refresh.png");

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
