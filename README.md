# CRUD Application

This repository contains a basic CRUD (Create, Read, Update, Delete) application implemented using Spring Boot, PostgreSQL, and Thymeleaf. It provides a simple example of managing entities in a database through a web interface.

---

## Features
- Create new records.
- View all records.
- Update existing records.
- Delete records.

---

## Technologies Used

- **Backend:** Spring Boot
- **Database:** PostgreSQL
- **Frontend:** Thymeleaf, HTML, CSS
- **Build Tool:** Maven

---

## Prerequisites

Before running this project, ensure that you have the following installed:

1. **Java Development Kit (JDK):** Version 11 or later.
2. **PostgreSQL Database:** Ensure a PostgreSQL server is running.
3. **Maven:** For building and running the project.
4. **Git:** For cloning the repository.

---

## Setup Instructions

### 1. Clone the Repository
```bash
$ git clone https://github.com/evez12/CRUD.git
$ cd CRUD
```

### 2. Configure the Database

Update the `application.properties` file located in `src/main/resources/` with your PostgreSQL database details:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_database_user
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build the Project

Run the following command to build the project:
```bash
$ mvn clean install
```

### 4. Run the Application

Use the following command to start the application:
```bash
$ mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## Usage

### Endpoints

1. **Homepage:** `http://localhost:8080` - View all records.
2. **Create Record:** `http://localhost:8080/create` - Add a new record.
3. **Update Record:** `http://localhost:8080/update/{id}` - Update an existing record by ID.
4. **Delete Record:** `http://localhost:8080/delete/{id}` - Delete a record by ID.

---

## Contributing

If you would like to contribute to this project, follow these steps:

1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Create a pull request.

---

## License

This project is open-source and available under the [MIT License](LICENSE).

---

## Contact

For any questions or issues, feel free to contact the repository owner at:

- **Name:** Əvəz
- **GitHub:** [evez12](https://github.com/evez12)

