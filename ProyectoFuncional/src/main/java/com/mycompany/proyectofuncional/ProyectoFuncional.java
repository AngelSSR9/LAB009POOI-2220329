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
                
        //3. Liste todos los desarrolladores que se unieron en el año 2023 (el año se extraerá del código del desarrollador, es decir, los primeros 4 caracteres)
        List<String> años = employeeList.stream().map(d->d.getCodigo().substring(0, 4)).toList();
        //4. Ordene los desarrolladores según el nombre; y luego ordene por salario.
        List<Desarrollador> desarrolladores = employeeList.stream().sorted((o1,o2)->o1.getNombres().compareTo(o2.getNombres())).collect(Collectors.toList());
        
        List<Desarrollador> salario = employeeList.stream().sorted((o1,o2)-> Double.compare(o1.getSalario(), o2.getSalario())).collect(Collectors.toList());
        

        //5. Imprima los nombres de todos los desarrolladores con el tercer salario más alto. (Generalícelo para el enésimo salario más alto).
            
        //6. Imprimir salario mínimo.
            
        //7. Imprima la lista de todos los desarrolladores con salario mínimo.
            
        
        //8. Liste a todas las personas que trabajan en más de 2 proyectos.
            
        //9. Conteo del total de laptops asignadas a los desarrolladores.
            int laptops = employeeList.stream().map(Desarrollador::getSalario).reduce(0,(t, u) -> t+u);
        //10. Recuento de todas las iniciativas con Luis Carrillo Lopez.
            
        //11. Lista de todas las personas que trabajan con Luis Carrillo Lopez.

        //12. Cree un mapa basado en estos datos, el key debe ser el año de incorporación y el valor debe ser la lista de todos los desarrolladores que se incorporaron en ese año en particular.
            
        //14. Cree un mapa basado en estos datos, el key debe ser el año de incorporación y el valor debe ser el recuento de personas que se unieron en ese año en particular.
            
    }
}
    
