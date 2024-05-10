import utility.*;
import objects.*;
import java.util.Scanner;

public class Adopt_a_pet {
    private static Scanner input = new Scanner(System.in);
    private static Ink ink = new Ink();
    private static User user;
    private static Shelter shelter = new Shelter();
    private static Pet pet;

    private static int choice;
    private static boolean isDone = false;

    public static void main(String[] args) {
        createUser(); // create the user
        createPets(); // helper pets

        do {
            choice = ink.validateMainMenu();

            switch (choice) {
                case 1: // print available pets
                    ink.printAvailablePets(shelter.getPets());
                    handlePetSelection();
                    break;
                case 2: // print shelter details
                    ink.printShelterDetails(shelter);
                    break;
                case 3: // book an appointment menu
                    ink.bookAppointment(user);
                    break;
                case 4: // exit
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (!isDone);

        ink.printGoodday();
    }

    // Method to handle pet selection and adoption
    private static void handlePetSelection() {
        boolean goBack = false;
        while (!goBack) {
            int pick = input.nextInt();
            if (pick != 0) {
                ink.printPetDetails(shelter.getPet(pick - 1));
                String answer = input.next();
                if (answer.equalsIgnoreCase("Y")) {
                    shelter.adopt(pick - 1, user.getName());
                    goBack = true;
                } else {
                    goBack = true;
                }
            } else {
                goBack = true;
            }
        }
    }

    // Method to create pets
    public static void createPets() {
        pet = new Pet("spot", "dog", 3, "black", "hound");
        shelter.addPet(pet);
        pet = new Pet("cleveland", "dog", 7, "brown", "boxer");
        shelter.addPet(pet);
        pet = new Pet("monster", "cat", 1, "calico", "calico");
        shelter.addPet(pet);
    }

    // Method to create user
    public static void createUser() {
      String name, email, phone;
  
      System.out.println("What is your name? ");
      name = input.nextLine();
      System.out.println("What is your email? ");
      email = input.nextLine();
      System.out.println("What is your phone? ");
      phone = input.nextLine();  
  
      user = new User(name, email, phone);
  }
  
  
  
}
