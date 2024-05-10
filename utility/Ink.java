package utility;

import objects.Shelter;
import objects.User; 
import java.util.Scanner;
import java.util.ArrayList;
import objects.Pet;

public class Ink {
  private Scanner input = new Scanner(System.in);
  private int choice;
  
  public void printWelcome() {
    // do nothing yet...
  } 

  public void printGoodday() {
    System.out.println("Have a great day pet lover");
  } 

  public int validateMainMenu() {
    boolean valid = false;

    while(!valid) {
      System.out.println("##### MAIN MENU #####");
      System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Exit");
      try {
        choice = input.nextInt();
        if(choice >= 1 && choice <=4) { // Corrected the upper limit of the range
          valid = true; 
        }
        else {
          System.out.println("Please enter a number between 1 and 4");
        }
      } 
      catch (Exception e) {
        System.out.println("That's not a number!");
      } 
      finally {
        input.nextLine();
      }
    } 
    return choice;
  } 

  public void printPetDetails(Pet pet) {
    System.out.printf("Name: %s\n", pet.getName());
    System.out.printf("Age: %d\n", pet.getAge());
    System.out.printf("Breed: %s\n", pet.getBreed());
    System.out.printf("Color: %s\n", pet.getColor());
    System.out.printf("Owner: %s\n", pet.getOwner());
    System.out.printf("Is Adopted: %b\n", pet.getIsAdopted());
    System.out.println("Adopt this pet? Y/N");
  } 

  public void printAvailablePets(ArrayList<Pet> pets) {
    for(int i = 0; i < pets.size(); i++) {
      if(!pets.get(i).getIsAdopted()) {
        System.out.printf("(%d) Name: %s Type: %s Age: %d\n", i + 1,
          pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge());
      }
    } 
    System.out.println("Enter 0 to go back");
  } 

  public void printShelterDetails(Shelter shelter) {
    System.out.printf("Shelter Address: %s\n", shelter.getAddress());
    String[] hours = shelter.getHours();
    for(int i = 0; i < hours.length; i++) {
      System.out.println(hours[i]);
    } 
    System.out.println("Hit any key to go back");
  } 

  public void printAppointmentMenu() {
    System.out.println("Please select a day for appointment:");
    System.out.println("1. Monday\n2. Tuesday\n3. Wednesday\n4. Thursday\n5. Friday\n6. Saturday\n7. Sunday");
  }

  public void bookAppointment(User user) {
    printAppointmentMenu(); // Invokes the new method to print the appointment menu
    int appointmentChoice = input.nextInt();
    String appointmentDay = "";
    switch (appointmentChoice) {
        case 1:
            appointmentDay = "Monday";
            break;
        case 2:
            appointmentDay = "Tuesday";
            break;
        case 3:
            appointmentDay = "Wednesday";
            break;
        case 4:
            appointmentDay = "Thursday";
            break;
        case 5:
            appointmentDay = "Friday";
            break;
        case 6:
            appointmentDay = "Saturday";
            break;
        case 7:
            appointmentDay = "Sunday";
            break;
        default:
            System.out.println("Invalid choice! Please enter a number between 1 and 7.");
    }
    user.setAppointmentDay(appointmentDay);
  }

} 
