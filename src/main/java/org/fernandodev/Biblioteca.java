package org.fernandodev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Biblioteca {

    public Biblioteca() {}

    public boolean validarCamposObligatorios(List<String> campos) {
        return campos.stream()
                .anyMatch(campo -> campo == null || campo.trim().isEmpty());
    }

}
