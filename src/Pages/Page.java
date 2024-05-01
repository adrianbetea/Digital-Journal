package Pages;

import javax.swing.*;

public interface Page {
    int width=512;
    int height=512;
    String page_name = "" ;
    ImageIcon logo = null;

    Page page(String page_name, int width, int height, ImageIcon logo);

}
