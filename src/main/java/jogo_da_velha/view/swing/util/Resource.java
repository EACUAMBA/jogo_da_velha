package jogo_da_velha.view.swing.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Resource {
    private Path resource = Paths.get(this.getResourceURI());

    private URI getResourceURI(){
        try{
            return this.getClass().getResource("/").toURI();
        }catch (URISyntaxException exception){
            System.err.println("Ocorreu um erro ao criar a URI!\nErro: " + exception.getMessage());
        }
        return null;
    }

    public Optional<Path> getResourcePath(){
        return Optional.of(this.resource);
    }
}
