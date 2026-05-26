package LinkedList.Design_Browser_History_DLL;


class Node {

    String url;

    Node next;
    Node back;

    Node(String url) {
        this.url = url;
    }
}

public class Browser_History {

    Node currentPage;

    // constructor
    public Browser_History(String homepage) {

        currentPage = new Node(homepage);
    }

    // VISIT NEW PAGE
    public void visit(String url) {

        Node newPage = new Node(url);

        // remove forward history
        currentPage.next = null;

        currentPage.next = newPage;

        newPage.back = currentPage;

        currentPage = newPage;
    }

    // MOVE BACK
    public String back(int steps) {

        while (steps > 0) {

            if (currentPage.back != null) {

                currentPage = currentPage.back;

            } else {
                break;
            }

            steps--;
        }

        return currentPage.url;
    }

    // MOVE FORWARD
    public String forward(int steps) {

        while (steps > 0) {

            if (currentPage.next != null) {

                currentPage = currentPage.next;

            } else {
                break;
            }

            steps--;
        }

        return currentPage.url;
    }

    // PSVM
    public static void main(String[] args) {

        Browser_History browser =
                new Browser_History("google.com");

        browser.visit("facebook.com");

        browser.visit("youtube.com");

        browser.visit("linkedin.com");

        System.out.println(
                "Back 1: " + browser.back(1)
        );

        System.out.println(
                "Back 1: " + browser.back(1)
        );

        System.out.println(
                "Forward 1: " + browser.forward(1)
        );

        browser.visit("github.com");

        System.out.println(
                "Forward 2: " + browser.forward(2)
        );

        System.out.println(
                "Back 2: " + browser.back(2)
        );

        System.out.println(
                "Back 7: " + browser.back(7)
        );
    }
}
