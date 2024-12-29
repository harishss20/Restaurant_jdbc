# 🏨 Restaurant JDBC Project

<p align="center">
	<img src="https://img.shields.io/github/license/harishss20/Restaurant_jdbc?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/harishss20/Restaurant_jdbc?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/harishss20/Restaurant_jdbc?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/harishss20/Restaurant_jdbc?style=default&color=0080ff" alt="repo-language-count">
</p>

## 📖 Project Description

The `Restaurant_JDBC` project is a Java-based application for managing restaurant operations. It leverages JDBC for database connectivity and allows functionalities like menu management, table registration, and order processing. This project demonstrates core Java skills, SQL integration, and object-oriented design principles.

---

## 📁 Project Structure

```sh
└── Restaurant_jdbc/
    ├── Restaurant.iml
    └── src
        └── Restaurant
```

### 📂 Project Index
<details open>
	<summary><b><code>RESTAURANT_JDBC/</code></b></summary>
	<details>
		<summary><b>src</b></summary>
		<blockquote>
			<details>
				<summary><b>Restaurant</b></summary>
				<blockquote>
					<table>
					<tr>
						<td><b><a href='https://github.com/harishss20/Restaurant_jdbc/blob/master/src/Restaurant/FoodOrder.java'>FoodOrder.java</a></b></td>
						<td>Manages food ordering functionality.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/harishss20/Restaurant_jdbc/blob/master/src/Restaurant/Menu.java'>Menu.java</a></b></td>
						<td>Handles menu-related operations.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/harishss20/Restaurant_jdbc/blob/master/src/Restaurant/DatabaseCon.java'>DatabaseCon.java</a></b></td>
						<td>Establishes database connection.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/harishss20/Restaurant_jdbc/blob/master/src/Restaurant/Main.java'>Main.java</a></b></td>
						<td>Entry point of the application.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/harishss20/Restaurant_jdbc/blob/master/src/Restaurant/TableReg.java'>TableReg.java</a></b></td>
						<td>Manages table registrations.</td>
					</tr>
					</table>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---

## 🛠 Technologies Used

- **Java**: Core programming language.
- **JDBC**: For database connectivity.
- **MySQL**: Backend database.
- **Git**: Version control.

---

## ✨ Features

- **Table Management**: Add and manage restaurant tables.
- **Menu Management**: View and update menu items.
- **Order Management**: Place and track customer orders.
- **Dynamic Pricing**: Calculate order totals based on the menu.
- **Database Integration**: Robust backend powered by MySQL.

---

## 🏃‍♂️ Usage Instructions

### ☑️ Prerequisites

- Install **Java** and ensure it’s added to your system PATH.
- Set up **MySQL** and create a database.
- Update database credentials in `DatabaseCon.java`.

### ⚙️ Installation

1. Clone the `Restaurant_jdbc` repository:
```sh
❯ git clone https://github.com/harishss20/Restaurant_jdbc
```

2. Navigate to the project directory:
```sh
❯ cd Restaurant_jdbc
```

3. Compile the project:
```sh
❯ javac -d bin src/Restaurant/*.java
```

4. Run the project:
```sh
❯ java -cp bin Restaurant.Main
```

### Application Navigation
- Follow on-screen prompts to manage tables, view the menu, and place orders.

---

## 🗄 Database Schema

### Tables
- **`Tables`**: Manages restaurant tables.
- **`Menu`**: Stores menu items and their details.
- **`Order_Items`**: Tracks orders, including table number, items, and quantities.

### Relationships
- `Order_Items.table_id` → References `Tables.table_id`
- `Order_Items.item_id` → References `Menu.item_id`

---

## 🧪 Testing

This project was tested manually for:
- Input validation.
- Database consistency.
- Error handling.

---

## 🚀 Future Improvements

- **Web Interface**: Develop a web-based frontend for easier access.
- **Mobile Integration**: Create a mobile app for real-time order management.
- **Analytics Dashboard**: Add insights into sales and table occupancy.

---

## 🔰 Contributing

- **💬 [Join the Discussions](https://github.com/harishss20/Restaurant_jdbc/discussions)**: Share your insights, provide feedback, or ask questions.
- **🐛 [Report Issues](https://github.com/harishss20/Restaurant_jdbc/issues)**: Submit bugs found or log feature requests for the `Restaurant_jdbc` project.
- **💡 [Submit Pull Requests](https://github.com/harishss20/Restaurant_jdbc/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

### Contributing Guidelines

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.
   ```sh
   git clone https://github.com/harishss20/Restaurant_jdbc
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to GitHub**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.

---

## 🎗 License

This project is protected under the [MIT License](https://choosealicense.com/licenses/mit/). For more details, refer to the [LICENSE](https://choosealicense.com/licenses/mit/) file.

---

## 📸 Screenshots

### Menu View
![Menu View](https://via.placeholder.com/600x400)

### Place Order
![Place Order](https://via.placeholder.com/600x400)



