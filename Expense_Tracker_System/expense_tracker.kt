import java.util.*

// Expense class represents a single expense entry
data class Expense(val date: String, val description: String, val amount: Double)

// ExpenseTracker class manages the expense records
class ExpenseTracker {
    private val expenses = mutableListOf<Expense>()

    // Function to add an expense entry
    fun addExpense(date: String, description: String, amount: Double) {
        val expense = Expense(date, description, amount)
        expenses.add(expense)
        println("Expense added successfully.")
    }

    // Function to delete an expense entry
    fun deleteExpense(index: Int) {
        if (index in 0 until expenses.size) {
            expenses.removeAt(index)
            println("Expense deleted successfully.")
        } else {
            println("Invalid index. Please try again.")
        }
    }

    // Function to display all expense entries
    fun displayExpenses() {
        if (expenses.isEmpty()) {
            println("No expenses found.")
        } else {
            println("Expense entries:")
            for ((index, expense) in expenses.withIndex()) {
                println("[$index] ${expense.date} - ${expense.description} - $${expense.amount}")
            }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val expenseTracker = ExpenseTracker()

    var exit = false
    while (!exit) {
        println("Expense Tracker")
        println("1. Add Expense")
        println("2. Delete Expense")
        println("3. View Expenses")
        println("4. Exit")
        print("Enter your choice: ")
        val choice = scanner.nextInt()

        when (choice) {
            1 -> {
                print("Enter expense date (MM/DD/YYYY): ")
                val date = scanner.next()
                scanner.nextLine() // Consume newline character
                print("Enter expense description: ")
                val description = scanner.nextLine()
                print("Enter expense amount: $")
                val amount = scanner.nextDouble()

                expenseTracker.addExpense(date, description, amount)
            }
            2 -> {
                print("Enter the index of the expense to delete: ")
                val index = scanner.nextInt()
                expenseTracker.deleteExpense(index)
            }
            3 -> expenseTracker.displayExpenses()
            4 -> exit = true
            else -> println("Invalid choice. Please try again.")
        }

        println()
    }
}
