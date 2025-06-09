 import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean isBooked;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Single"));
        rooms.add(new Room(201, "Double"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(301, "Suite"));
    }

    static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println("Room " + room.roomNumber + " - " + room.type);
            }
        }
    }

    static void makeReservation(Scanner scanner) {
        System.out.print("\nEnter room number to book: ");
        int roomNumber = scanner.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                if (!room.isBooked) {
                    room.isBooked = true;
                    System.out.println("Room " + roomNumber + " booked successfully!");
                } else {
                    System.out.println("Room is already booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    static void viewBookings() {
        System.out.println("\nBooked Rooms:");
        boolean hasBookings = false;
        for (Room room : rooms) {
            if (room.isBooked) {
                System.out.println("Room " + room.roomNumber + " - " + room.type);
                hasBookings = true;
            }
        }
        if (!hasBookings) {
            System.out.println("No rooms booked yet.");
        }
    }
}
