package jogo_da_velha.view.swing.util;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    private static Path resource ;
    private static Font font;
    private static Color bg_dark, bg_light;
    static {
        resource = new Resource().getResourcePath().orElseThrow(()->new RuntimeException("Não foi possível obter o Path"));
        font = carregaFont();
        bg_dark = new Color(27, 67, 83);
        bg_light = new Color(244, 255, 253);
    }

    private static Font carregaFont(){
        Font font = null;
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, Files.newInputStream(resource.resolve("font/Montserrat-Regular.ttf")));
        }catch (IOException|FontFormatException e){
            System.err.println("Erro ao criar font.\nErro: " + e.getMessage());
        }
        return font;
    }

    public static Font obterFontPersonalizada(){
        return font;
    }

    public static Path obterPathResource(){
        return resource;
    }
    public static byte[] obterBytesApartirFilePath(Path path){
        byte[] bytes = new byte[]{};
        try {
            bytes = Files.readAllBytes(path);
        }catch (IOException e){
            System.err.println("Ocorreu um erro ao converter o ficheiro em array de bytes[].\nErro: " + e.getMessage());
        }
        return bytes;
    }

    public static Font obterFontTitulo(){
        Font fontTitulo = null;

        fontTitulo = font.deriveFont(Font.BOLD, 18);

        return fontTitulo;
    }

    public static Font obterFontTextoComum(){
        Font fontTitulo = null;

        fontTitulo = font.deriveFont(Font.PLAIN, 14);

        return fontTitulo;
    }

    public static Color obterCorDark(){
        return bg_dark;
    }

    public static Color obterCorLight(){
        return bg_light;
    }
}
