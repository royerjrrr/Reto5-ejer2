package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
  private static  List<Contacto> contactos = new ArrayList<>(10);

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int opc;
      do {
          opc = 0;
          System.out.println("Menu Contacto" +
                  "\n1. Añadir contactos" +
                  "\n2. Existe contacto" +
                  "\n3. Lista de contacto" +
                  "\n4. Busca contacto" +
                  "\n5. Eliminar contacto" +
                  "\n6. Agenda contacto" +
                  "\n7. Hueco agenda"
          );
          System.out.print("Elije la opcion: ");
          opc = scanner.nextInt();
          switch (opc) {
              case 1:
                  //Pedimos cuanto contacto quiere crear
                  System.out.print("N. de contacto para llenar: ");
                   int capacidad = scanner.nextInt();

                  while (contactos.size() < capacidad) {
                      System.out.println("Nombre del contacto: ");
                      String nombre = scanner.next();
                      System.out.println("Numero del contacto: ");
                      String telefono = scanner.next();
                      Contacto contacto = new Contacto(nombre, telefono);
                      addContact(contacto);
                  }


                  scanner.nextLine();
                  break;
              case 2:
                  System.out.println("Digame el nombre del contacto a verificar: ");
                  String nombre = scanner.next();
                  Contacto contacto = new Contacto(nombre, "");
                  isContact(contacto);
                  scanner.nextLine();
                  break;
              case 3:
                  listarAgenda();
                  break;
              case 4:
                  System.out.println("Nombre del contacto: ");
                  String nombre2 = scanner.next();
                  Contacto contacto3 = new Contacto(nombre2, "");
                  encontraContacto(contacto3);
                  break;
              case 5:
                  System.out.println("Digame el nombre del contacto a eliminar: ");
                  nombre2 = scanner.next();
                  Contacto contacto2 = new Contacto(nombre2, "");
                  removeContact(contacto2);
                  break;
              case 6:
                agendaLlena();
                  break;
              case 7:
                  huecoLibres();
                    break;
          }
      } while (opc != 8);



  }

  private static void addContact(Contacto contacto) {
    contactos.add(contacto);
  }

  private static void listarAgenda() {
    for (Contacto c : contactos) {
      System.out.println(c);
    }
  }

  private static void isContact(Contacto contacto) {
    for (Contacto i : contactos) {
      if (i.getNombre().equals(contacto.getNombre())) {
        System.out.println("Contacto encontrado");
        return;
      }
    }
    System.out.println("No existe");
  }




private static void removeContact(Contacto contacto) {
    for (Contacto c : contactos) {
        if (c.getNombre().equals(contacto.getNombre())) {
            contactos.remove(c);
            System.out.println("Contacto eliminado");
            return;
        }
    }
    System.out.println("Contacto no encontrado");
}
    /*private static void llenar(){
        if (contactos.isEmpty()) {
            System.out.println("Vacio");
        } else {
            System.out.println("Lleno");
        }
    } */

    private static void encontraContacto(Contacto contacto3){
    for (Contacto c : contactos) {
        if (c.getNombre().equals(contacto3.getNombre())) {
            System.out.println(c.getTelefono());
        }
    }
    }

    private static void agendaLlena(){
        if (contactos.size() == 10){
            System.out.println("La agenda esta llena");
        }else {
            System.out.println("no esta llena");

            }
        }


        private static void huecoLibres() {
            int a = 10 - contactos.size();
            System.out.println("Capacity = " + a);
        }

    }


