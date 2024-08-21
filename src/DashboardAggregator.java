import java.util.concurrent.CompletableFuture;

public class DashboardAggregator {
    public static void main(String[] args) {
        CompletableFuture<String> profileFuture = CompletableFuture.supplyAsync(() -> getUserProfile());
        CompletableFuture<String> transactionsFuture = CompletableFuture.supplyAsync(() -> getRecentTransactions());
        CompletableFuture<Integer> notificationsFuture = CompletableFuture.supplyAsync(() -> getNotificationCount());

        CompletableFuture<String> dashboardFuture = profileFuture
                .thenCombine(transactionsFuture, (profile, transactions) -> profile + "\n" + transactions)
                .thenCombine(notificationsFuture, (profileAndTransactions, notifications) ->
                        profileAndTransactions + "\nUnread Notifications: " + notifications);

        dashboardFuture.thenAccept(System.out::println);
    }

    private static String getUserProfile() {
        // Simulate fetching user profile
        return "User Profile: John Doe";
    }

    private static String getRecentTransactions() {
        // Simulate fetching recent transactions
        return "Recent Transactions: [Tx1, Tx2, Tx3]";
    }

    private static Integer getNotificationCount() {
        // Simulate fetching notification count
        return 5;
    }
}
