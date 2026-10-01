import java.util.Scanner;

public class MusicPlaylist {

    // Node class
    static class Node {
        String song;
        Node next;

        Node(String song) {
            this.song = song;
            this.next = null;
        }
    }

    // Head of the linked list
    Node head = null;

    // 1. Add a song
    void addSong(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Song added: " + song);
    }

    // 2. Remove a song
    void removeSong(String song) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        // If the first song needs to be removed
        if (head.song.equalsIgnoreCase(song)) {
            head = head.next;
            System.out.println("Song removed: " + song);
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.song.equalsIgnoreCase(song)) {
                current.next = current.next.next;
                System.out.println("Song removed: " + song);
                return;
            }

            current = current.next;
        }

        System.out.println("Song not found.");
    }

    // 3. Display playlist
    void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node current = head;

        System.out.println("\nMusic Playlist:");

        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MusicPlaylist playlist = new MusicPlaylist();

        int choice;

        do {
            System.out.println("\n--- Music Playlist ---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();
                    playlist.addSong(song);
                    break;

                case 2:
                    System.out.print("Enter song to remove: ");
                    String removeSong = sc.nextLine();
                    playlist.removeSong(removeSong);
                    break;

                case 3:
                    playlist.displayPlaylist();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}

Input/Output
  --- Music Playlist ---
1. Add Song
2. Remove Song
3. Display Playlist
4. Exit
Enter your choice: 1
Enter song name: hoyna
Song added: hoyna

--- Music Playlist ---
1. Add Song
2. Remove Song
3. Display Playlist
4. Exit
Enter your choice: 1
Enter song name: lyra
Song added: lyra

--- Music Playlist ---
1. Add Song
2. Remove Song
3. Display Playlist
4. Exit
Enter your choice: 3

Music Playlist:
hoyna
lyra
