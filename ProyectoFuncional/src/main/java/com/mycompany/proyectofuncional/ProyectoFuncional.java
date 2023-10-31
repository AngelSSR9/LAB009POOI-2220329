package com.mycompany.proyectofuncional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProyectoFuncional {

    static List<Desarrollador> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        IniciativaFactory employeeFactory = new IniciativaFactory();
        employeeList = employeeFactory.getAllDesarrolladores();

        //TODO
        //1. Enumere todas las iniciativas distintas de manera descente.
        List<Iniciativa> iniciativa = employeeList.stream().flatMap(d -> d.getIniciativas().stream()).sorted((a1, a2) -> a1.getNombre().compareTo(a2.getNombre())).distinct().toList();
        iniciativa.forEach(o -> System.out.println(o.getNombre()));
        //2. Imprima el nombre completo de cualquier desarrollador cuyo nombre comience con "A".
        List<Desarrollador> empiezanConA = employeeList.stream().filter(e -> e.getNombres().startsWith("A")).toList();
        empiezanConA.forEach(d -> System.out.println(d.getNombres()));

        //3. Liste todos los desarrolladores que se unieron en el año 2023 (el año se extraerá del código del desarrollador, es decir, los primeros 4 caracteres)
        
        //4. Ordene los desarrolladores según el nombre; y luego ordene por salario.
        List<Desarrollador> desarrolladores = employeeList.stream().sorted((o1, o2) -> o1.getNombres().compareTo(o2.getNombres())).collect(Collectors.toList());

        List<Desarrollador> salario = employeeList.stream().sorted((o1, o2) -> Double.compare(o1.getSalario(), o2.getSalario())).collect(Collectors.toList());

        //5. Imprima los nombres de todos los desarrolladores con el tercer salario más alto. (Generalícelo para el enésimo salario más alto).
        double tercerSalario = salario.stream()
                .mapToDouble(Desarrollador::getSalario)
                .distinct()
                .skip(2)
                .findFirst()
                .orElse(0); // Puedes manejar el caso en que no haya suficientes salarios distintos

        // Imprimir los nombres de los desarrolladores con el tercer salario más alto
        System.out.println("Desarrolladores con el tercer salario más alto (" + tercerSalario + "):");
        employeeList.stream()
                .filter(d -> d.getSalario() == tercerSalario)
                .map(d -> d.getNombres() + " " + d.getApellidos())
                .forEach(System.out::println);
        //6. Imprimir salario mínimo.
        Desarrollador salarioMinimo = employeeList.stream()
            .sorted((emp1, emp2) -> Double.compare(emp1.getSalario(), emp2.getSalario()))
            .findFirst()
            .orElse(null);
        
        System.out.println(salarioMinimo.getSalario());
        //7. Imprima la lista de todos los desarrolladores con salario mínimo.
        List<Desarrollador> desarrolladoresMin = employeeList.stream()
                .filter(d -> d.getSalario() == salarioMinimo.getSalario())
                .toList();
        desarrolladoresMin.forEach(d -> System.out.println(d.getNombres()));
        
        //8. Liste a todas las personas que trabajan en más de 2 proyectos.
        //9. Conteo del total de laptops asignadas a los desarrolladores.
        int laptops = employeeList.stream().map(Desarrollador::getSalario).reduce(0, (t, u) -> t + u);
        //10. Recuento de todas las iniciativas con Luis Carrillo Lopez.
        List<Iniciativa> iniciativasLuis = employeeList.stream()
            .flatMap(d -> d.getIniciativas().stream()) // Obtener todas las iniciativas de todos los desarrolladores
            .filter(i -> "Luis Carrillo Lopez".equals(i.getNombreProjectManager())) // Filtrar por el nombre del Project Manager
            .distinct() // Eliminar elementos duplicados
            .collect(Collectors.toList()); // Recolectar en una lista
        //11. Lista de todas las personas que trabajan con Luis Carrillo Lopez.
        //12. Cree un mapa basado en estos datos, el key debe ser el año de incorporación y el valor debe ser la lista de todos los desarrolladores que se incorporaron en ese año en particular.
        //14. Cree un mapa basado en estos datos, el key debe ser el año de incorporación y el valor debe ser el recuento de personas que se unieron en ese año en particular.
    }
}
