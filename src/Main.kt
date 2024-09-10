// Data class to represent a Task
data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var isCompleted: Boolean = false
)

// display the menu and get user input
fun displayMenu(): Int {
    println("Menu:")
    println("1. Add Task")
    println("2. View All Tasks")
    println("3. Update Task")
    println("4. Delete Task")
    println("5. Mark Task as Completed")
    println("6. Exit")
    print("Enter your choice: ")
    return readLine()?.toIntOrNull() ?: -1
}

// add a new task
fun addTask(taskList: MutableList<Task>) {
    print("Enter task ID: ")
    val id = readLine()?.toIntOrNull() ?: return
    print("Enter task title: ")
    val title = readLine() ?: return
    print("Enter task description: ")
    val description = readLine() ?: return

    taskList.add(Task(id, title, description))
    println("Task added successfully!")
}

// view all tasks
fun viewTasks(taskList: List<Task>) {
    if (taskList.isEmpty()) {
        println("No tasks available.")
    } else {
        taskList.forEach { task ->
            println("ID: ${task.id}, Title: ${task.title}, Description: ${task.description}, Completed: ${task.isCompleted}")
        }
    }
}

// update an existing task
fun updateTask(taskList: MutableList<Task>) {
    print("Enter task ID to update: ")
    val id = readLine()?.toIntOrNull() ?: return
    val task = taskList.find { it.id == id }
    if (task != null) {
        print("Update Title: ")
        val newTitle = readLine()
        if (!newTitle.isNullOrEmpty()) task.title = newTitle

        print("Update Description: ")
        val newDescription = readLine()
        if (!newDescription.isNullOrEmpty()) task.description = newDescription

        println("Task updated successfully!")
    } else {
        println("Task not found.")
    }
}

// delete a task
fun deleteTask(taskList: MutableList<Task>) {
    print("Enter task ID to delete: ")
    val id = readLine()?.toIntOrNull() ?: return
    if (taskList.removeIf { it.id == id }) {
        println("Task deleted successfully.")
    } else {
        println("Task not found.")
    }
}

// Mark task as completed
fun markTaskAsCompleted(taskList: MutableList<Task>) {
    print("Enter task ID to mark as completed: ")
    val id = readLine()?.toIntOrNull() ?: return
    val task = taskList.find { it.id == id }
    if (task != null) {
        task.isCompleted = true
        println("Task marked as completed!")
    } else {
        println("Task not found.")
    }
}

// Main function for To-Do-App
fun main() {
    val taskList = mutableListOf<Task>()

    while (true) {
        when (displayMenu()) {
            1 -> addTask(taskList)
            2 -> viewTasks(taskList)
            3 -> updateTask(taskList)
            4 -> deleteTask(taskList)
            5 -> markTaskAsCompleted(taskList)
            6 -> {
                println("Exiting...Congratulations Tussi Jeet Gaye")
                break
            }
            else -> println("Invalid option, please try again.")
        }
    }
}
